package com.example.yuxuan.app

import android.os.Bundle
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.fragment.app.FragmentActivity
import androidx.viewpager.widget.ViewPager
import com.example.yuxuan.R
import com.example.yuxuan.base.MainFragmentAdapter

class MainActivity : FragmentActivity() {
    var viewpager:ViewPager?=null
    var rg:RadioGroup?=null
    var rb_home:RadioButton?=null
    var rb_payback:RadioButton?=null
    var rb_help:RadioButton?=null
    var rb_user:RadioButton?=null


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
        viewpager?.adapter = MainFragmentAdapter(supportFragmentManager)
        viewpager?.offscreenPageLimit=3

        viewpager!!.addOnPageChangeListener(object: ViewPager.OnPageChangeListener{
            //当前选中页面
            override fun onPageSelected(position: Int) {
                    when(position){
                        0 -> rg?.check(R.id.rb_home)
                        1 -> rg?.check(R.id.rb_payback)
                        2 -> rg?.check(R.id.rb_help)
                        3 -> rg?.check(R.id.rb_user)
                    }

            }

            override fun onPageScrollStateChanged(state: Int) {

            }

            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {

            }
        })

        //RadioGroup选中监听
        rg!!.setOnCheckedChangeListener(object:RadioGroup.OnCheckedChangeListener{
            override fun onCheckedChanged(group: RadioGroup?, checkedId: Int) {
                when(checkedId){
                    R.id.rb_home -> viewpager?.setCurrentItem(0,false)
                    R.id.rb_payback -> viewpager?.setCurrentItem(1,false)
                    R.id.rb_help -> viewpager?.setCurrentItem(2,false)
                    R.id.rb_user -> viewpager?.setCurrentItem(3,false)
                }
            }
        })

        //选中首页
        rg?.check(R.id.rb_home)
    }


}
























