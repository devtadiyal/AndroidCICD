package com.example.composecrash.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.composecrash.data.AppConstants
import com.example.composecrash.data.ResourceState
import com.example.composecrash.data.entity.MealsResponse
import com.example.composecrash.data.entity.NewsResponse
import com.example.composecrash.ui.repository.NewsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor(private val newsRepository: NewsRepository): ViewModel() {

    private val _news: MutableStateFlow<ResourceState<NewsResponse>> = MutableStateFlow(ResourceState.Loading())
    private val _meals: MutableStateFlow<ResourceState<MealsResponse>> = MutableStateFlow(ResourceState.Loading())
    val news: StateFlow<ResourceState<NewsResponse>> = _news
    val meals: StateFlow<ResourceState<MealsResponse>> = _meals

    init {
        getNews(AppConstants.COUNTRY)
        //getMeals(AppConstants.COUNTRY_CANADA)
    }

    private fun getNews(country: String){
        viewModelScope.launch(Dispatchers.IO) {
            newsRepository.getNewsArticles(country)
                .collectLatest { response ->
                    _news.value = response
                }
        }
    }

    private fun getMeals(country: String){
        viewModelScope.launch(Dispatchers.IO) {
            newsRepository.getMealItems(country)
                .collectLatest { response ->
                    _meals.value = response
                }
        }
    }
}