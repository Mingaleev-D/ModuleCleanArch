package com.example.modulecleanarch.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.module_data.local.ArticlesDao
import com.example.module_domain.model.Article

/**
 * @author : Mingaleev D
 * @data : 29.10.2023
 */

@Database(entities = [Article::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

   companion object {

      fun getInstance(context: Context): AppDatabase {
         return Room.databaseBuilder(
             context,
             AppDatabase::class.java,
             "app_database"
         ).fallbackToDestructiveMigration().build()
      }
   }

   abstract fun getArticlesDao(): ArticlesDao
}