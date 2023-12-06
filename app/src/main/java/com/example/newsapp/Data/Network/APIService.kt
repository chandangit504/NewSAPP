package com.example.newsapp.Data.Network

import com.example.newsapp.Common.Resource
import com.example.newsapp.Data.Model.ArticleDTO
import com.example.newsapp.Data.Model.NewsDTO
import com.example.newsapp.domain.model.Article
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query


interface APIService {

//   This function is used to get the article for the news where we are
//    need two query parameter country and api key
//    This is a get call , after get call we are providing the end point.

@GET("top-headlines")
suspend fun getNewsArticle(
    @Query("country")country : String = "us",
    @Query("apiKey")apiKey: String = "499fd336930741e49f1b71f20a0f2bad"
) : Response<NewsDTO>


}