package com.example.module_domain.repository

import com.example.module_domain.model.Article

/**
 * @author : Mingaleev D
 * @data : 29.10.2023
 */

interface NewsRepository {

   suspend fun fetchNewsArticle():List<Article>
}