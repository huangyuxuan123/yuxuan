package com.example.yuxuan.home.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModelProviders

abstract class BaseActivity<VD:ViewDataBinding,VM: BaseVM>:AppCompatActivity(){
    //=========================  ================================
    lateinit var mViewDataBinding:VD
    lateinit var mViewModel:VM

    //=========================  ================================
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getLayoutId()
        onCreateViewDataBinding()
        onCreateViewModel()
        setViewModel()
        onInitData()
        onInitView()
    }

    abstract fun getLayoutId():Int

    abstract fun getViewModelCls():Class<VM>

    abstract fun setViewModel()

    open fun onInitData(){}

    open fun onInitView(){}


    private fun onCreateViewDataBinding(){
        mViewDataBinding = DataBindingUtil.setContentView(this,getLayoutId())
        mViewDataBinding.lifecycleOwner = this
    }

    private fun onCreateViewModel(){
        mViewModel = ViewModelProviders.of(this).get(getViewModelCls())
    }

}