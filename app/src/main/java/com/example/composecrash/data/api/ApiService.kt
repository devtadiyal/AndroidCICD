package com.example.composecrash.data.api

import com.example.composecrash.data.AppConstants.API_KEY
import com.example.composecrash.data.entity.MealsResponse
import com.example.composecrash.data.entity.NewsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("top-headlines")
    suspend fun getNewsArticles(
        @Query("country") country: String,
        @Query("apiKey") apiKey: String = API_KEY
    ): Response<NewsResponse>

    @GET("api/json/v1/1/filter.php")
    suspend fun getMealItems(
        @Query("a") country: String
    ): Response<MealsResponse>
}