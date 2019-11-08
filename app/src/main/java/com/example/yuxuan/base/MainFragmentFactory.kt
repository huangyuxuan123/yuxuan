package com.example.yuxuan.base

import com.example.yuxuan.help.HelpFragment
import com.example.yuxuan.home.view.HomeFragment
import com.example.yuxuan.payback.PaybackFragment
import com.example.yuxuan.user.UserFragment

class MainFragmentFactory {
    var  mSavedFragment:HashMap<Int,BaseFragment?> = HashMap<Int,BaseFragment?>()

    //根据position得到对应的fragment
    companion object fun getFragment(position:Int):BaseFragment?{
        var fragment: BaseFragment ?= mSavedFragment.get(position)
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