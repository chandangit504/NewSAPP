package com.example.newsapp.Data.Mapper

import com.example.newsapp.Data.Model.ArticleDTO
import com.example.newsapp.domain.model.Article


//its a inline function which is converting all Data->NEWSDTO data to Domain->Article data
// map is used to convert List of data to another list of data, if there is single data response
// we can use normal[ return (Article( andcontent =  this.content)]
fun List<ArticleDTO>.toDomainArticle(): List<Article>{
    return map {
             Article(
                 content = it.content?:"",
                 description = it.description?:"",
                 title = it.title?:"",
                 urlToImage = it.urlToImage?:""

             )
    }

}