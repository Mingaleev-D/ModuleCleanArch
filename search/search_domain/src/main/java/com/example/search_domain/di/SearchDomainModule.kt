package com.example.search_domain.di

import com.example.search_domain.repository.SearchRepository
import com.example.search_domain.use_case.GetSearchUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object SearchDomainModule {

   @Provides
   fun provideSearchUseCase(searchRepository: SearchRepository): GetSearchUseCase {
      return GetSearchUseCase(searchRepository)
   }
}