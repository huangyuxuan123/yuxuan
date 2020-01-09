package com.example.yuxuan.home.model

import com.example.yuxuan.home.contract.ApiService
import com.example.yuxuan.utils.Constants
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class Http {
    //=========================  =================================
    private var retrofit:Retrofit? = null
    private var okHttpClient: OkHttpClient? = null
    private var apiService:ApiService? = null

    //=========================  =================================
    companion object {
        private var httpInstance: Http? = null
        fun getInstance():Http{
            if(httpInstance == null){
                httpInstance = Http()
            }
            return httpInstance as Http
        }
    }

    constructor(){
         retrofit = Retrofit.Builder()
            //设置网络请求
            .client(getOkHttpClient())
            //设置返回类型为RXJava
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            //设置返回数据类型
            .addConverterFactory(GsonConverterFactory.create())
            //设置url
            .baseUrl(Constants.url)
            .build()

        //绑定service
        apiService = retrofit?.create(ApiService::class.java)
    }

     fun getApiService():ApiService?{
        return apiService
    }


    //=========================  =================================
    private fun getOkHttpClient(): OkHttpClient? {
        okHttpClient = OkHttpClient().newBuilder()
            .addInterceptor(getAuthInterceptor())
            .build()
        return okHttpClient
    }

    //添加拦截器
    private fun getAuthInterceptor():Interceptor{
        val authInterceptor = Interceptor { chain ->
            val newUrl = chain.request().url()
                .newBuilder()
                .build()

            //添加请求头
            val newRequest = chain.request()
                .newBuilder()
                .url(newUrl)
                .addHeader("Content-Type","application/json; charset=UTF-8")
                .addHeader("imei","")
                .addHeader("version","3.4.0")
                .addHeader("client","1")
                .addHeader("token","")
                .build()

            chain.proceed(newRequest)

        }
        return authInterceptor
    }

}