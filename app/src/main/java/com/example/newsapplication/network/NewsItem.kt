package com.example.newsapplication.network;

//data class for parsing json response
data class ResponseData(
    val status: String,
    val totalResults: Double,
    val articles: List<NewsItem>
)

// data class for individual news items
data class NewsItem(
    val author: String,
    val title: String,
    val description: String,
    val url: String,
    val urlToImage: String,
    val publishedAt: String
)
