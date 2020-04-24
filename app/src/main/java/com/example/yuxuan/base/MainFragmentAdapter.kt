package com.example.yuxuan.base

import android.util.Log
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.yuxuan.home.HomeFragment
import com.example.yuxuan.home.base.BaseFragment

class MainFragmentAdapter: FragmentPagerAdapter {
    var mainFragmentFactory:MainFragmentFactory= MainFragmentFactory()
    var current:Fragment? = null

    constructor(fm:FragmentManager):super(fm)

    //返回ViewPager要显示的item数量
    override fun getCount(): Int {
        return 4
    }

    //根据position得到对应的fragment对象
    override fun getItem(position: Int): Fragment {
       var fragment:Fragment = mainFragmentFactory.getFragment(position) as Fragment
        return fragment
    }

}