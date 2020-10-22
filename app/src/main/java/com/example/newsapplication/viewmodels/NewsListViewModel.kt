package com.example.newsapplication.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsapplication.network.NewsAPIStatus
import com.example.newsapplication.network.NewsApiService
import com.example.newsapplication.network.NewsItem
import kotlinx.coroutines.launch
import javax.inject.Inject

// Use of ViewModel as per recommended jetpack components.
class NewsListViewModel @Inject constructor(private val newsApiServiceDependency: NewsApiService) :
    ViewModel() {

    private val TAG = "NewsListViewModel"

    private val _newsItems = MutableLiveData<List<NewsItem>>()
    val newsItems: LiveData<List<NewsItem>>
        get() = _newsItems

    private val _status = MutableLiveData<NewsAPIStatus>()
    val status: LiveData<NewsAPIStatus>
        get() = _status

    init {
        getNewsItems()
    }

    // Method to get News items from NewsAPI.
    private fun getNewsItems() {
        viewModelScope.launch {
            try {
                _status.value = NewsAPIStatus.LOADING
                val apiResponse = newsApiServiceDependency.getNewsItems(
                    "android",
                    "2020-09-15",
                    "2020-08-15",
                    "popularity",
                    "5b25e38d6ad94983a987a0a138cbba25"
                )
                _newsItems.value = apiResponse.articles
                _status.value = NewsAPIStatus.DONE

            } catch (e: Exception) {
                _status.value = NewsAPIStatus.ERROR
                _newsItems.value = ArrayList()
            }
        }
    }
}
