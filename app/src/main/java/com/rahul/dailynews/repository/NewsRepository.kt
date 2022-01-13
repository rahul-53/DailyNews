package com.rahul.dailynews.repository


import androidx.lifecycle.MutableLiveData
import com.rahul.dailynews.api.Network
import com.rahul.dailynews.model.local.ArticleDatabase
import com.rahul.dailynews.model.remote.NewsResponse
import com.rahul.dailynews.util.Resource
import retrofit2.Retrofit

class NewsRepository(val db:ArticleDatabase ) {
    suspend fun getBreakingNews(countryCode:String, page:Int) =
        Network.newsApi.getBreakingNews(countryCode,page)

    suspend fun searchForNews(searchQuery: String, pageNumber:Int) =
        Network.newsApi.getSearchedNews(searchQuery, pageNumber)

}
