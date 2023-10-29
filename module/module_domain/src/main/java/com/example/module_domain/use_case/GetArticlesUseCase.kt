package com.example.module_domain.use_case

import com.example.common_utils.Resource
import com.example.module_domain.model.Article
import com.example.module_domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

/**
 * @author : Mingaleev D
 * @data : 29.10.2023
 */

class GetArticlesUseCase(
    private val newsRepository: NewsRepository
) {

   operator fun invoke(): Flow<Resource<List<Article>>> = flow {
      emit(Resource.Loading())
      try {
         emit(Resource.Success(data = newsRepository.fetchNewsArticle()))
      } catch (ex: Exception) {
         emit(Resource.Error(message = ex.message.toString()))
      }
   }
}