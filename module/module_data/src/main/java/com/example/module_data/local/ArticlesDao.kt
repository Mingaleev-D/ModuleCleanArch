package com.example.module_data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.module_domain.model.Article

/**
 * @author : Mingaleev D
 * @data : 29.10.2023
 */

@Dao
interface ArticlesDao {

   @Insert(onConflict = OnConflictStrategy.REPLACE)
   suspend fun insertList(list: List<Article>)

   @Query("SELECT * FROM Article")
   suspend fun getArticles(): List<Article>
}