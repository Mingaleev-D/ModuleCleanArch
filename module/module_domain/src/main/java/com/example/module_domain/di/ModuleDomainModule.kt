package com.example.module_domain.di

import com.example.module_domain.repository.NewsRepository
import com.example.module_domain.use_case.GetArticlesUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object ModuleDomainModule {

   @Provides
   fun provideGetArticleUseCase(newsRepository: NewsRepository): GetArticlesUseCase {
      return GetArticlesUseCase(newsRepository)

   }
}