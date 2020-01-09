package com.example.yuxuan.home.contract

import com.example.yuxuan.home.bean.BaseBean
import com.example.yuxuan.home.bean.ProductBean
import com.example.yuxuan.home.bean.ResultBean
import io.reactivex.Observable
import retrofit2.http.POST

/**
 * 接口请求
 */
interface ApiService {
    //首页产品列表接口
    @POST("/hzed/loan-api/index/V2/getProducts")
    fun getProducts(): Observable<BaseBean<ResultBean<ProductBean>>>
}