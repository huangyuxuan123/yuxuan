package com.example.yuxuan

import android.app.Application

class myapplication:Application() {
    companion object{
        lateinit var context :Application
    }

    override fun onCreate() {
        super.onCreate()
        context = this
    }
}