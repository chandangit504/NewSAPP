package com.example.newsapp.domain.Repository

import com.example.newsapp.domain.model.Article


// Here the concept is we are declaring a interface of all the data we eed
// it's implementaion will be inside the Data package

interface GetRepository {
    suspend fun getNewsList(): List<Article>
}