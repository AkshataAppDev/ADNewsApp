package com.example.newsapplication

import com.example.newsapplication.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class MyApplication : DaggerApplication() {
    override fun onCreate() {
        super.onCreate()
    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {

        // returns AppComponent
        return DaggerAppComponent.builder().application(this).build();
    }

}