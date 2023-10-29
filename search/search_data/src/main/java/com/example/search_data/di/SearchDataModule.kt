package com.example.search_data.di

import com.example.search_data.remote.ApiSerch
import com.example.search_data.repository.SearchRepositoryImpl
import com.example.search_domain.repository.SearchRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
object SearchDataModule {

   @Provides
   fun provideSearchApi(retrofit: Retrofit): ApiSerch {
      return retrofit.create(ApiSerch::class.java)
   }

   @Provides
   fun provideSearchRepository(apiSerch: ApiSerch): SearchRepository {
      return SearchRepositoryImpl(apiSerch)
   }
}