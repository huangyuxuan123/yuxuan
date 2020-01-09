package com.example.yuxuan.home

import com.example.yuxuan.home.base.BaseVM
import com.example.yuxuan.home.bean.BaseBean
import com.example.yuxuan.home.bean.ProductBean
import com.example.yuxuan.home.bean.ResultBean
import com.example.yuxuan.home.http.mod.ModHome
import io.reactivex.disposables.Disposable
import io.reactivex.observers.DisposableObserver


class HomeFragmentVM : BaseVM(){
    //=========================  =================================
    var modHome = ModHome()
    private var dispose: Disposable? = null
    var watcher:Watcher? = null

    //=========================  =================================
    fun getProducts(){
        dispose = modHome.getProducts()?.subscribeWith(object : DisposableObserver<BaseBean<ResultBean<ProductBean>>>(){
            override fun onNext(t: BaseBean<ResultBean<ProductBean>>) {
//                Log.e("yyy", "-->${Gson().toJson(t)}")
                watcher?.setData(t.result.userProductTypeCards)
            }

            override fun onComplete() {

            }

            override fun onError(e: Throwable) {

            }

        })

//        dispose?.dispose()
    }

    interface Watcher{
        fun setData(data: List<ProductBean>?)
    }
}