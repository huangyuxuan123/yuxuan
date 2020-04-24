package com.example.yuxuan.app

import android.os.Bundle
import android.util.Log
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager.widget.ViewPager
import com.example.yuxuan.R
import com.example.yuxuan.base.MainFragmentAdapter
import kotlinx.android.synthetic.main.activity_main.*
import com.example.yuxuan.home.HomeFragment
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T



class MainActivity : FragmentActivity(),RadioGroup.OnCheckedChangeListener,ViewPager.OnPageChangeListener{
    //=========================  =================================
    var viewpager:ViewPager?=null
    var rg:RadioGroup?=null
    var rb_home:RadioButton?=null
    var rb_payback:RadioButton?=null
    var rb_help:RadioButton?=null
    var rb_user:RadioButton?=null
    var adapter:MainFragmentAdapter? = null

    //=========================  =================================
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewpager = findViewById(R.id.viewpager)
        rg = findViewById(R.id.rg)
        rb_home = findViewById(R.id.rb_home)
        rb_payback = findViewById(R.id.rb_payback)
        rb_help = findViewById(R.id.rb_help)
        rb_user = findViewById(R.id.rb_user)

        //设置适配器
        adapter = MainFragmentAdapter(supportFragmentManager)
        viewpager?.offscreenPageLimit=3
        viewpager?.adapter  = adapter

        //选中首页
        rg?.check(R.id.rb_home)

        //设置监听
        rg?.setOnCheckedChangeListener(this)
        viewpager?.addOnPageChangeListener(this)

    }

    //========================= onclick =================================
    //RadioGroup选中监听
    override fun onCheckedChanged(group: RadioGroup?, checkedId: Int) {
        when(checkedId){
            R.id.rb_home -> viewpager?.setCurrentItem(0,false)
            R.id.rb_payback -> viewpager?.setCurrentItem(1,false)
            R.id.rb_help -> viewpager?.setCurrentItem(2,false)
            R.id.rb_user -> viewpager?.setCurrentItem(3,false)
        }
    }

    override fun onPageScrollStateChanged(state: Int) {

    }

    override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {

    }

    //当前选中页面
    override fun onPageSelected(position: Int) {
        when(position){
            0 -> rg?.check(R.id.rb_home)
            1 -> rg?.check(R.id.rb_payback)
            2 -> rg?.check(R.id.rb_help)
            3 -> rg?.check(R.id.rb_user)
        }
    }

}