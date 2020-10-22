package com.example.newsapplication.di

import androidx.lifecycle.ViewModel
import com.example.newsapplication.viewmodels.NewsListViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

//Module class for the ViewModel itself.

@Module
abstract class NewsListViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(NewsListViewModel::class) // mapping viewmodel into viewmodel key.
    abstract fun bindNewsListViewModel(newsListViewModel: NewsListViewModel): ViewModel
}