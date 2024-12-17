package com.example.composecrash.data.datasource

import com.example.composecrash.data.entity.MealsResponse
import com.example.composecrash.data.entity.NewsResponse
import retrofit2.Response

interface NewsDataSource {
    suspend fun getNewsArticles(country: String): Response<NewsResponse>
}

interface MealDataSource {
    suspend fun getMealItems(country: String): Response<MealsResponse>
}