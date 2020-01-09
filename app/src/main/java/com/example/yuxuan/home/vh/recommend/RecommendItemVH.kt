package com.example.yuxuan.home.vh.recommend

import android.view.View
import android.view.ViewGroup
import com.example.yuxuan.R
import com.example.yuxuan.databinding.RecommendItemBinding
import com.example.yuxuan.home.base.BaseVH
import com.example.yuxuan.home.bean.ProductBean
import com.example.yuxuan.home.contract.Clicker

class RecommendItemVH(vg:ViewGroup) : BaseVH<RecommendItemBinding,RecommendItemVM>(vg, R.layout.recommend_item),Clicker{
    override fun setViewModel() {
        ui.vm = vm
        ui.click = this
    }

    override fun getViewModelCls(): Class<RecommendItemVM> {
        return RecommendItemVM::class.java
    }

    fun setData(data:List<ProductBean>?){
        data?.get(0)?.let {
            vm.productTypeName.value = it.productTypeName
            vm.buttonName.value = it.buttonName
            vm.amount.value = it.amount.toString()
        }

        var str= data?.get(0)?.productKeywords
        var index:String = ","
        var s = str?.split(index)

        s?.let {
            vm.Keyword_One.value = it.get(0)
            vm.Keyword_Two.value = it.get(1)
            vm.Keyword_Three.value = it.get(2)
        }
    }

    override fun onClick(v: View?) {
        super.onClick(v)
        when(v) {
            ui.buttonName -> vm.onClick(v)
        }
    }
}