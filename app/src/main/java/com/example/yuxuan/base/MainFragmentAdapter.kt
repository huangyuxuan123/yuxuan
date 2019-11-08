package com.example.yuxuan.base

import android.os.Parcel
import android.os.Parcelable
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class MainFragmentAdapter: FragmentPagerAdapter {
    var mainFragmentFactory:MainFragmentFactory= MainFragmentFactory()

    constructor(fm:FragmentManager):super(fm)

    //返回ViewPager要显示的item数量
    override fun getCount(): Int {
        return 4
    }

    //根据position得到对应的fragment对象
    override fun getItem(position: Int): Fragment {
       var fragment:Fragment = mainFragmentFactory.getFragment(position) as BaseFragment
        return fragment
    }

}