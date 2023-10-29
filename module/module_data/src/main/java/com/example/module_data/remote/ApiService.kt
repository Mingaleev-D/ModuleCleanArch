package com.example.module_data.remote

import com.example.common_utils.Constants
import com.example.module_data.BuildConfig
import com.example.module_data.remote.model.NewsResponseDto
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * @author : Mingaleev D
 * @data : 29.10.2023
 */

interface ApiService {

   @GET("top-headlines")
   suspend fun fetchNEwsHeadlines(
       @Query("country") country: String = "us",
       @Query("category") category: String = Constants.CATEGORY_END,
       @Query("apiKey") apiKey: String = BuildConfig.API_KEY,
   ): NewsResponseDto
}