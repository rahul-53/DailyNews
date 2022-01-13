package com.rahul.dailynews.model.remote

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable


@Entity(tableName = "newsDB")
data class Article(
    @PrimaryKey(autoGenerate = true)
    val Id:Int?=null,
    val author: String,
    val content: String,
    val description: String,
    val publishedAt: String,
    val source: Source,
    val title: String,
    val url: String,
    val urlToImage: String
)