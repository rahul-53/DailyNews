package com.rahul.dailynews.api

import com.rahul.dailynews.model.remote.NewsResponse
import com.rahul.dailynews.util.Constants.Companion.API_KEY
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsAPI {

    @GET("v2/top-headlines")
    suspend fun getBreakingNews(
        @Query("country")
        countryCode: String = "us",

        @Query("pge")
        pageNumber: Int = 1,

        @Query("apikey")
        apiKey: String = API_KEY
    ): Response<NewsResponse>

    @GET("v2/everything")
    suspend fun getSearchedNews(
        @Query("query")
        searchQuery: String,

        @Query("pge")
        pageNumber: Int = 1,

        @Query("apikey")
        apiKey: String = API_KEY
    ): Response<NewsResponse>
}