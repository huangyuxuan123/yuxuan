package com.example.yuxuan.help

import com.example.yuxuan.R
import com.example.yuxuan.databinding.HelpFragmentBinding
import com.example.yuxuan.home.base.BaseFragment

class HelpFragment : BaseFragment<HelpFragmentBinding,HelpFragmentVM>(){
    //=========================  ================================

    override fun getLayoutId(): Int = R.layout.help_fragment

    //=========================  =================================

    override fun getViewModelCls(): Class<HelpFragmentVM> {
        return HelpFragmentVM::class.java
    }

    override fun setViewModel() {
        mViewDataBinding.vm= mViewModel
    }

}