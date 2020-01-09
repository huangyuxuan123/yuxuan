package com.example.yuxuan.home.base

import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStore
import androidx.recyclerview.widget.RecyclerView
import com.example.yuxuan.myapplication


abstract class BaseVH<VDB : ViewDataBinding, VM : BaseVM>(vg:ViewGroup,id:Int) : RecyclerView.ViewHolder(ViewTools.inflate(id,vg)){
    //=========================  ================================
    protected lateinit var vm : VM
    var ui: VDB

    //=========================  ================================
    private  var mAppViewModelStore: ViewModelStore = ViewModelStore()
    var viewModelStoreOwner = ViewModelProvider(mAppViewModelStore,ViewModelProvider.AndroidViewModelFactory.getInstance(myapplication.context))

    //=========================  ================================
    abstract fun setViewModel()

    abstract fun getViewModelCls():Class<VM>

    init {
        vm = viewModelStoreOwner.get(getViewModelCls())
        ui = DataBindingUtil.bind(itemView)!!
        setViewModel()
    }
}