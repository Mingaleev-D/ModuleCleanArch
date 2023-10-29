package com.example.search_data.remote

import com.example.search_data.remote.model.NewsResponseDto
import retrofit2.http.GET
import retrofit2.http.QueryMap

/**
 * @author : Mingaleev D
 * @data : 29.10.2023
 */

interface ApiSerch {

   @GET("everything")
   suspend fun fetchSearchArticles(
       @QueryMap map:MutableMap<String, String>
   ): NewsResponseDto
}