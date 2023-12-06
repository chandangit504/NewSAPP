package com.example.newsapp

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsapp.Common.Resource
import com.example.newsapp.Presentaion.State
import com.example.newsapp.domain.usecases.NewsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class NewsViewModel @Inject constructor(private val useCase: NewsUseCase) : ViewModel() {
    val article = mutableStateOf(State())

    init {
        getArticles()
    }

     fun getArticles() {

            useCase().onEach {

                when (it) {
                    is Resource.Loading -> {
                    article.value= State(isLoading = true)
                    }

                    is Resource.Error -> {
                        article.value=State(error = it.message)

                    }

                    is Resource.Success -> {
                        article.value= State(data = it.data)
                    }
                }
            }.launchIn(viewModelScope)
    }
}
