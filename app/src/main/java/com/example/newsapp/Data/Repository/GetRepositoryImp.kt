package com.example.newsapp.Data.Repository

import com.example.newsapp.Common.SafeApiCall
import com.example.newsapp.Data.Mapper.toDomainArticle
import com.example.newsapp.Data.Network.APIService
import com.example.newsapp.domain.Repository.GetRepository
import com.example.newsapp.domain.model.Article
import javax.inject.Inject

// Here we are implimenting the repository which basically will give us the all get Api body and from that
// response we ar
class GetRepositoryImp @Inject constructor(private val apiService: APIService) : GetRepository,SafeApiCall() {
    override suspend fun getNewsList(): List<Article> {
        val response = safeApiRequest { apiService.getNewsArticle() }
        return response.articles.toDomainArticle()!!

    }

}