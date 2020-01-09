package com.example.yuxuan.payback

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.yuxuan.R
import com.example.yuxuan.databinding.PaybackFragmentBinding
import com.example.yuxuan.home.base.BaseFragment

class PaybackFragment: BaseFragment<PaybackFragmentBinding,PaybackFragmentVM>(){

    //=========================  =================================
    override fun getLayoutId(): Int = R.layout.payback_fragment

    //=========================  =================================

    override fun getViewModelCls(): Class<PaybackFragmentVM> {
        return PaybackFragmentVM::class.java
    }


    override fun setViewModel() {
        mViewDataBinding.vm= mViewModel
    }

}