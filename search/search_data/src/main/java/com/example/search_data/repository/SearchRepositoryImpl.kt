package com.example.search_data.repository

import com.example.search_data.mapper.toDomainArticle
import com.example.search_data.remote.ApiSerch
import com.example.search_domain.model.Article
import com.example.search_domain.repository.SearchRepository

/**
 * @author : Mingaleev D
 * @data : 29.10.2023
 */

class SearchRepositoryImpl(
    private val seApiSerch: ApiSerch
):SearchRepository {

   override suspend fun fetchSearchArticles(map: MutableMap<String, String>): List<Article> {
      return seApiSerch.fetchSearchArticles(map).articles.map { it.toDomainArticle() }
   }
}