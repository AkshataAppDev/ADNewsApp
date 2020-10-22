package com.example.newsapplication.di

import com.example.newsapplication.network.NewsApiService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

//class to provide NewsApiService dependency.
@Module
object NewsModule {
    @Provides
    fun providesNewsApiService(retrofit: Retrofit):  NewsApiService{
        return retrofit.create(NewsApiService::class.java)
    }
}