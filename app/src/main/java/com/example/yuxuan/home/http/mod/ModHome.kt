package com.example.yuxuan.home.http.mod

import com.example.yuxuan.home.bean.BaseBean
import com.example.yuxuan.home.bean.ProductBean
import com.example.yuxuan.home.bean.ResultBean
import com.example.yuxuan.home.model.Http
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class ModHome {
    //首页产品列表
    fun getProducts(): Observable<BaseBean<ResultBean<ProductBean>>>? {
        return Http.getInstance().getApiService()?.getProducts()?.subscribeOn(Schedulers.io())?.observeOn(AndroidSchedulers.mainThread())
    }
}