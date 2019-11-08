package com.example.yuxuan.utils
import android.view.View
import android.widget.Toast

/**
 * 点击事件处理类
 */
class OnClickHandle {
        //buttonName的点击事件
        public fun onClickbuttonName(view: View){
            Toast.makeText(view.context,"立即申请",Toast.LENGTH_SHORT).show()
    }
}