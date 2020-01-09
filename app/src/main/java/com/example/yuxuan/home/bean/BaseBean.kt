package com.example.yuxuan.home.bean

class BaseBean<T:Any>{
    var code: Int = 0
    var message: String = ""
    lateinit var result: T
}