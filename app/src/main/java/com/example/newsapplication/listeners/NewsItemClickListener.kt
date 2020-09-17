package com.example.newsapplication.listeners


import com.example.newsapplication.network.NewsItem

// listener class for handling clicks on news items.
class NewsItemClickListener(val clickListener: (newsItem: NewsItem) -> Unit) {
    fun onClick(newsItem: NewsItem) = clickListener(newsItem)
}