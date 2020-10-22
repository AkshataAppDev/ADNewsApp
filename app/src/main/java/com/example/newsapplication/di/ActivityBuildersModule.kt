package com.example.newsapplication.di

import com.example.newsapplication.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

// Class to declare all activities that could be injected with dependencies.

@Module
 abstract class ActivityBuildersModule {

    // NewsListFragment should exists only in MainActivity(for now)
    @ContributesAndroidInjector(modules = [MainFragmentsBuildersModule::class])
    abstract fun contributeMainActivity(): MainActivity

}