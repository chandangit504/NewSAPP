package com.example.ewsapp.Presentaion.Screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberAsyncImagePainter
import com.example.newsapp.NewsViewModel
import com.example.newsapp.domain.model.Article

@Composable
fun HomeScreen(viewModel: NewsViewModel = hiltViewModel()){
    val res = viewModel.article.value

    if (res.isLoading){
        Box(modifier = Modifier.fillMaxSize()){
            CircularProgressIndicator()
        }
    }
    if (res.error.isNullOrEmpty()){
        Box(modifier = Modifier.fillMaxSize()){
            res.error?.let { Text(text = it) }
        }
    }
    res.data?.let {
        LazyColumn{
            items(items = it){
                ShowArticle(it)
            }
        }
    }
}
@Composable
private fun ShowArticle(it: Article){
    Column {
        Image(painter = rememberAsyncImagePainter(model = it.urlToImage), contentDescription ="",
            modifier = Modifier
                .height(300.dp)
                .fillMaxSize(),
            contentScale = ContentScale.Crop)
    }
    Text(text = it.title)
    Spacer(modifier = Modifier.height(12.dp))
}