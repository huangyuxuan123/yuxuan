package com.example.yuxuan.home.model

import com.example.yuxuan.home.bean.Products
import com.example.yuxuan.utils.Constants
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * 从网络上获取数据
 */
class ProductsModel {
    //首页产品列表
    fun getProducts(): Observable<Products>? {
        return Http.getInstance()?.getApiService()?.getProducts()?.subscribeOn(Schedulers.io())?.observeOn(AndroidSchedulers.mainThread())
    }
}