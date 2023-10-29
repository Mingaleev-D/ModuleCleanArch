package com.example.search_domain.use_case

import com.example.common_utils.Resource
import com.example.search_domain.model.Article
import com.example.search_domain.repository.SearchRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

/**
 * @author : Mingaleev D
 * @data : 29.10.2023
 */

class GetSearchUseCase(
    private val searchRepository: SearchRepository
) {

   operator fun invoke(map: MutableMap<String, String>): Flow<Resource<List<Article>>> = flow {
      emit(Resource.Loading())
      try {
         emit(Resource.Success(searchRepository.fetchSearchArticles(map)))
      } catch (ex: Exception) {
         emit(Resource.Error(ex.message ?: "Error search"))
      }
   }
}