package com.example.modulecleanarch.di

import android.content.Context
import com.example.common_utils.Navigator
import com.example.module_data.local.ArticlesDao
import com.example.modulecleanarch.room.AppDatabase
import com.example.modulecleanarch.ui.navigator.DefaultNavigator
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MainModule {

   @Provides
   @Singleton
   fun providerProvider(): Navigator.Provider {
      return DefaultNavigator()
   }

   @Provides
   @Singleton
   fun provideArticlesDatabase(@ApplicationContext context: Context): AppDatabase {
      return AppDatabase.getInstance(context)
   }

   @Provides
   fun provideArticlesDao(appDatabase: AppDatabase): ArticlesDao {
      return appDatabase.getArticlesDao()
   }
}