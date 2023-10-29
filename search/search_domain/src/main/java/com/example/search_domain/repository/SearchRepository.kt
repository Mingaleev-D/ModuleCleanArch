package com.example.search_domain.repository

import com.example.search_domain.model.Article

/**
 * @author : Mingaleev D
 * @data : 29.10.2023
 */

interface SearchRepository {

   suspend fun fetchSearchArticles(map: MutableMap<String, String>): List<Article>
}