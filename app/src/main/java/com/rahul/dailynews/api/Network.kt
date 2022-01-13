package com.rahul.dailynews.api

import com.rahul.dailynews.util.Constants.Companion.BASE_URL
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class Network {

    companion object{
        private val retrofit by lazy {
            val loggingInterceptor= HttpLoggingInterceptor()
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
            val httpClient = OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .build()

            Retrofit.Builder()
                .baseUrl(BASE_URL )
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient)
                .build()
        }

        val newsApi by lazy {
            retrofit.create(NewsAPI::class.java)
        }
    }
}