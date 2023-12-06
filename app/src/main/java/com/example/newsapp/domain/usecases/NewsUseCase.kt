package com.example.newsapp.domain.usecases

import com.example.newsapp.Common.Resource
import com.example.newsapp.domain.Repository.GetRepository
import com.example.newsapp.domain.model.Article
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class NewsUseCase @Inject constructor(private val getRepository: GetRepository){

    operator fun invoke() : Flow<Resource<List<Article>>> = flow {

        emit(Resource.Loading())
        try {
             emit(Resource.Success(getRepository.getNewsList()))
        }
        catch (e: Exception){
            emit(Resource.Error(e.message))

        }
    }
}