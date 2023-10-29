package com.example.module_data.repository

import com.example.module_data.local.ArticlesDao
import com.example.module_data.mapper.toDomainArticle
import com.example.module_data.remote.ApiService
import com.example.module_data.remote.model.ArticleDto
import com.example.module_domain.model.Article
import com.example.module_domain.repository.NewsRepository

/**
 * @author : Mingaleev D
 * @data : 29.10.2023
 */

class NewsRepositoryImpl(
    private val apiService: ApiService,
    private val dao: ArticlesDao
) : NewsRepository {

   override suspend fun fetchNewsArticle(): List<Article> {
      return try {
         val response = apiService.fetchNEwsHeadlines().articles.map(ArticleDto::toDomainArticle)
         dao.insertList(response)
         dao.getArticles()
      } catch (ex: Exception) {
         dao.getArticles()
      }

   }
}