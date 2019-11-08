package com.example.yuxuan.home.viewmodel

import androidx.databinding.ObservableField
import com.example.yuxuan.home.model.ProductsModel
import com.example.yuxuan.home.bean.Products
import com.example.yuxuan.home.bean.ProductsBean
import com.example.yuxuan.home.interfaces.DataListener
import com.example.yuxuan.home.view.HomeFragment
import io.reactivex.observers.DisposableObserver

public class ProductsViewModel {
    private var mActivity: HomeFragment?=null
    var productsModel: ProductsModel?=null

    constructor(activity: HomeFragment){
        this.mActivity = activity
    }


    public fun loadProducts(dataListener: DataListener<ProductsBean>) {
        //加载数据
        productsModel = ProductsModel()
        productsModel?.getProducts()?.subscribeWith(object : DisposableObserver<Products>(){
            override fun onNext(t: Products) {
                //Log.e("eee","-->${Gson().toJson(t)}")
                //处理数据
                var bean:ProductsBean  = handleData(t)
                //传数据给view
                dataListener.getData(bean)

            }

            override fun onComplete() {

            }

            override fun onError(e: Throwable) {

            }

        })

    }

    //处理数据
    private fun handleData(list: Products):ProductsBean{
        //把要显示的数据单独抽取出来放到Bean中
        //Log.e("abc",""+t.result.userProductTypeCards.get(0).productTypeName)  //爱分期
        //Log.e("www","-->${Gson().toJson(list)}") //json

        //分解productKeywords数据
        // Log.e("abc",""+list.result.userProductTypeCards.get(0).productKeywords)  //360天,12期,年息最低仅35.8%
        var str:String = list.result.userProductTypeCards.get(0).productKeywords
        var index:String = ","
        var s = str.split(index)

        var bean:ProductsBean = ProductsBean()
        bean.keyword_One = ObservableField(s[0])//360天
        bean.keyword_Two = ObservableField(s[1])//12期
        bean.keyword_Three = ObservableField(s[2])//年息最低仅35.8%

        bean.amount = ObservableField(list.result.userProductTypeCards.get(0).amount.toString()+".00") //15000.00
        bean.productTypeName = ObservableField(list.result.userProductTypeCards.get(0).productTypeName)
        bean.buttonName = ObservableField(list.result.userProductTypeCards.get(0).buttonName)

        return bean

    }

}