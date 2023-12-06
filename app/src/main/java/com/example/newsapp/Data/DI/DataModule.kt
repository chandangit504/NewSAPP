package com.example.newsapp.Data.DI

import com.example.newsapp.Common.Constant
import com.example.newsapp.Data.Network.APIService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

@InstallIn(SingletonComponent::class)
@Module
object DataModule {

//   We are creating instance of rectrofit , so that no need to call same code again and again
    //to use this class through out the application
    // this method will provide the api response which is implemented inside APIServices

    @Provides
    fun provideApiServices() :APIService{
        val Base_Url: String= "https://newsapi.org/v2/"
         return Retrofit.Builder().baseUrl(Base_Url).
         addConverterFactory(GsonConverterFactory.create()).build().
         create(APIService::class.java)
    }
}