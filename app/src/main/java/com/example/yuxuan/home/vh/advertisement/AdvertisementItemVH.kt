package com.example.yuxuan.home.vh.advertisement

import android.view.ViewGroup
import com.example.yuxuan.R
import com.example.yuxuan.databinding.AdvertisementItemBinding
import com.example.yuxuan.home.base.BaseVH

class AdvertisementItemVH(vg: ViewGroup) : BaseVH<AdvertisementItemBinding, AdvertisementItemVM>(vg, R.layout.advertisement_item){
    override fun setViewModel() {
        ui.vm = vm
    }

    override fun getViewModelCls(): Class<AdvertisementItemVM> {
        return AdvertisementItemVM::class.java
    }

}