package com.example.yuxuan.base

import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import com.example.yuxuan.help.HelpFragment
import com.example.yuxuan.home.HomeFragment
import com.example.yuxuan.home.base.BaseFragment
import com.example.yuxuan.home.base.BaseVM
import com.example.yuxuan.payback.PaybackFragment
import com.example.yuxuan.user.UserFragment

class MainFragmentFactory {
    var  mSavedFragment:HashMap<Int, Fragment?> = HashMap()

    //根据position得到对应的fragment
    companion object fun getFragment(position:Int):Fragment?{
        var fragment= mSavedFragment.get(position)
        if(fragment == null){
            when(position){
                0 -> fragment = HomeFragment()
                1 -> fragment = PaybackFragment()
                2 -> fragment = HelpFragment()
                3 -> fragment = UserFragment()
            }
            mSavedFragment.put(position,fragment)
        }
        return fragment
    }

    fun deleteFragment(){
        for(index in 0..3){
            mSavedFragment.remove(index)
        }
    }
}