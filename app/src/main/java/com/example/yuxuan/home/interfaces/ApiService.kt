package com.example.yuxuan.home.interfaces

import com.example.yuxuan.home.bean.Products
import io.reactivex.Observable
import retrofit2.http.POST

/**
 * 接口请求
 */
interface ApiService {
    //首页产品列表接口
    @POST("/hzed/loan-api/index/V2/getProducts")
    fun getProducts(): Observable<Products>
}