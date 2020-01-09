package com.example.yuxuan.home.base

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders

abstract class BaseFragment<VD: ViewDataBinding,VM: BaseVM> : Fragment() {
    //=========================  ================================
    var mContext: Context? = null
    lateinit var mViewDataBinding:VD
    lateinit var mViewModel:VM

    //=========================  ================================
    abstract fun getLayoutId():Int

    abstract fun getViewModelCls():Class<VM>

    abstract fun setViewModel()

    open fun onInitView() {}

    //=========================  ================================
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        mViewModel = ViewModelProviders.of(this).get(getViewModelCls())
        mViewDataBinding = DataBindingUtil.inflate(inflater,getLayoutId(),container,false)
        mViewDataBinding.lifecycleOwner = this
        setViewModel()
        onInitView()

        return mViewDataBinding.root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContext = context
    }
}