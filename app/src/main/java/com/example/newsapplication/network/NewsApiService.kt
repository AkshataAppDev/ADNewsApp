package com.example.newsapplication.network

import retrofit2.http.GET
import retrofit2.http.Query

public const val BASE_URL = "http://newsapi.org/v2/"

enum class NewsAPIStatus { LOADING, ERROR, DONE }

//Use of Retrofit and Moshi library to parse incoming JSON response.

// No need as dependency is being used.
//private val retrofit = Retrofit.Builder()
//    .addConverterFactory(MoshiConverterFactory.create())
//    .baseUrl(BASE_URL)
//    .build()

interface NewsApiService {
    @GET("everything")
    suspend fun getNewsItems(
        @Query("q") query: String,
        @Query("from") fromDate: String,
        @Query("to") toDate: String,
        @Query("sortBy") sortBy: String,
        @Query("apiKey") apiKey: String
    ): ResponseData
}

// No need as dependency is being used.
// Retrofit instance
//object NewsApi {
//    val retrofitService: NewsApiService by lazy {
//        retrofit.create(NewsApiService::class.java)
//    }
//}