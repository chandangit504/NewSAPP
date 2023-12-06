package com.example.newsapp.domain.DI

import com.example.newsapp.Data.Network.APIService
import com.example.newsapp.Data.Repository.GetRepositoryImp
import com.example.newsapp.domain.Repository.GetRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object DomainModule {

    @Provides
    fun providegetNesRepo(apiService: APIService): GetRepository{
        return GetRepositoryImp(apiService)
    }
}