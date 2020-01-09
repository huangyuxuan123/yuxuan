package com.example.yuxuan.user

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.yuxuan.R
import com.example.yuxuan.databinding.UserFragmentBinding
import com.example.yuxuan.home.HomeFragmentVM
import com.example.yuxuan.home.base.BaseFragment

class UserFragment: BaseFragment<UserFragmentBinding,UserFragmentVM>(){

    //=========================  =================================
    override fun getLayoutId(): Int = R.layout.user_fragment

    //=========================  =================================
    override fun getViewModelCls(): Class<UserFragmentVM> {
        return UserFragmentVM::class.java
    }

    override fun setViewModel() {
        mViewDataBinding.vm= mViewModel
    }

}