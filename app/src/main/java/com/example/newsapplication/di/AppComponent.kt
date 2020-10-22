package com.example.newsapplication.di

import android.app.Application
import com.example.newsapplication.MyApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

// AppComponent for Application exists as long as app.

@Singleton
@Component(modules = [AndroidSupportInjectionModule::class,
    ActivityBuildersModule::class,
    AppModule::class,
    ViewModelFactoryModule::class])
interface AppComponent : AndroidInjector<MyApplication> {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application?): Builder
        fun build(): AppComponent
    }
}