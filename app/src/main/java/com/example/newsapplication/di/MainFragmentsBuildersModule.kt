package com.example.newsapplication.di

import com.example.newsapplication.fragments.NewsListFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

// class to declare fragments that could be injected with dependencies and could be used only for MainActivity.

@Module
abstract class MainFragmentsBuildersModule
{
    @ContributesAndroidInjector(modules = [NewsListViewModelModule::class, NewsModule::class])
    abstract fun contributeNewsListFragment(): NewsListFragment
}