package com.example.module_data.remote.model


import com.google.gson.annotations.SerializedName

data class ArticleDto(
    @SerializedName("author")
    val author: String = "",
    @SerializedName("content")
    val content: Any? = null,
    @SerializedName("description")
    val description: Any? = null,
    @SerializedName("publishedAt")
    val publishedAt: String = "",
    @SerializedName("source")
    val source: SourceDto = SourceDto(),
    @SerializedName("title")
    val title: String = "",
    @SerializedName("url")
    val url: String = "",
    @SerializedName("urlToImage")
    val urlToImage: Any? = null
)