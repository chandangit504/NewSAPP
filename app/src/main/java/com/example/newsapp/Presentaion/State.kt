package com.example.newsapp.Presentaion

import com.example.newsapp.domain.model.Article

data class State(
    val isLoading:Boolean = false,
    val data: List<Article>? = null,
    val error: String? = ""
)