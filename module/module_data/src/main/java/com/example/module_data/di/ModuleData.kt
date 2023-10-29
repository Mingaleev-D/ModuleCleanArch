package com.example.module_data.di

import com.example.module_data.local.ArticlesDao
import com.example.module_data.remote.ApiService
import com.example.module_data.repository.NewsRepositoryImpl
import com.example.module_domain.repository.NewsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.create

@Module
@InstallIn(SingletonComponent::class)
object ModuleData {

   @Provides
   fun provideApiService(retrofit: Retrofit): ApiService {
      return retrofit.create(ApiService::class.java)
   }

   @Provides
   fun provideRepository(apiService: ApiService, articDao: ArticlesDao): NewsRepository {
      return NewsRepositoryImpl(apiService = apiService, dao = articDao)
   }
}