package com.rahul.dailynews.model.remote

data class NewsResponse(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)