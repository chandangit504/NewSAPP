package com.example.newsapp.Data.Model

data class ArticleDTO(
    val author: String,
    val content: String,
    val description: String,
    val publishedAt: String,
    val source: SourceDTO?,
    val title: String,
    val url: String,
    val urlToImage: String

)
