package com.example.yuxuan.payback

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.yuxuan.R
import com.example.yuxuan.base.BaseFragment

class PaybackFragment: BaseFragment(){
    override fun initView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        var view:View = inflater.inflate(R.layout.payback_fragment,container,false)
        return view
    }
}