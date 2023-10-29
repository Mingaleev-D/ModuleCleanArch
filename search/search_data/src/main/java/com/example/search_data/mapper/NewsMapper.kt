package com.example.search_data.mapper

import com.example.search_data.remote.model.ArticleDto
import com.example.search_domain.model.Article

/**
 * @author : Mingaleev D
 * @data : 29.10.2023
 */

fun ArticleDto.toDomainArticle(): Article {
   return Article(
       author = this.author ?: "",
       content = this.content.toString() ?: "",
       description = this.description.toString() ?: "",
       title = this.title ?: "",
       urlToImage = this.urlToImage.toString() ?: ""
   )
}