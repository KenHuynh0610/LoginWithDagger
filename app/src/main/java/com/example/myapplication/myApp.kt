package com.example.myapplication

import android.app.Application
import dagger.Component

class MyApp: Application() {
    lateinit var appComponent: AppComponent

    override fun onCreate(){
        super.onCreate()
        appComponent = DaggerAppComponent.create()
    }

}