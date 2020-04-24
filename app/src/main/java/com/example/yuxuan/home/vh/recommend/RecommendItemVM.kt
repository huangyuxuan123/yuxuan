package com.example.yuxuan.home.vh.recommend

import android.view.View
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import com.example.yuxuan.home.base.BaseVM

class RecommendItemVM: BaseVM(){
    var amount = MutableLiveData<String>()
    var productTypeName = MutableLiveData<String>()
    var Keyword_One = MutableLiveData<String>()
    var Keyword_Two = MutableLiveData<String>()
    var Keyword_Three = MutableLiveData<String>()
    var buttonName = MutableLiveData<String>()

    open fun onClick(v: View?){
        Toast.makeText(v?.context,"立即申请",Toast.LENGTH_SHORT).show()
    }
}