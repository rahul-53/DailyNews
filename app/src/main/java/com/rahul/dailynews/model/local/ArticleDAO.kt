package com.rahul.dailynews.model.local

import androidx.lifecycle.LiveData
import androidx.room.*
import com.rahul.dailynews.model.remote.Article

@Dao
interface ArticleDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun update(article:Article):Long

    @Query("SELECT * FROM newsDB")
    fun getArticles():LiveData<List<Article>>

    @Delete
    suspend fun deleteArticle(article: Article)
}