package com.example.yuxuan.home.interfaces

/**
 * viewmodel层返回数据给view层
 */
interface DataListener<T> {
    fun getData(data:T)
}