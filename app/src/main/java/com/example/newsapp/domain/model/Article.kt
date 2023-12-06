package com.example.newsapp.domain.model

import com.example.newsapp.Data.Model.SourceDTO



//Here the Article is coming from the news data class and we are needing these
// cases for showing the data on usecases because we need only this fields to show th
// news inside our application we don't need all the data what we are getting from the response


data class Article(
    val content: String,
    val description: String,
    val title: String,
    val urlToImage: String
) {
}