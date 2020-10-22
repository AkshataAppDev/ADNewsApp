package com.example.newsapplication.di

import android.app.Application
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.bumptech.glide.request.RequestOptions
import com.example.newsapplication.R
import com.example.newsapplication.network.BASE_URL
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton


//Class to delcare global dependencies that will prabbaly not change and should exist along with app.

@Module
object AppModule {

    //Retrofit
    @Singleton
    @Provides
    fun  provideRetrofitInstance(): Retrofit
    {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .build();
    }

    // Glide RequestOptions
    @Singleton
    @Provides
     fun provideRequestOptions(): RequestOptions {
        return RequestOptions.placeholderOf(R.drawable.loading_animation)
            .error(R.drawable.ic_broken_image)
    }

    //Glide
    @Singleton
    @Provides
     fun provideGlideInstance(
        application: Application?,
        requestOptions: RequestOptions?
    ): RequestManager {
        return Glide.with(application!!)
            .setDefaultRequestOptions(requestOptions!!)
    }
}