package com.example.composecrash.data.datasource

import com.example.composecrash.data.api.ApiService
import com.example.composecrash.data.entity.MealsResponse
import com.example.composecrash.data.entity.NewsResponse
import retrofit2.Response
import javax.inject.Inject

class NewsDataSourceImpl @Inject constructor(
    private val apiService: ApiService
) : NewsDataSource, MealDataSource {
    override suspend fun getNewsArticles(country: String): Response<NewsResponse> {
        return apiService.getNewsArticles(country)
    }

    override suspend fun getMealItems(country: String): Response<MealsResponse> {
        return apiService.getMealItems(country)
    }
}