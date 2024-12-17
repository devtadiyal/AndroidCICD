package com.example.composecrash.ui.repository

import com.example.composecrash.data.ResourceState
import com.example.composecrash.data.datasource.MealDataSource
import com.example.composecrash.data.datasource.NewsDataSource
import com.example.composecrash.data.entity.MealsResponse
import com.example.composecrash.data.entity.NewsResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class NewsRepository @Inject constructor(
    private val newsDataSource: NewsDataSource,
    private val mealDataSource: MealDataSource
) {
    suspend fun getNewsArticles(country: String): Flow<ResourceState<NewsResponse>> {
        return flow {
            emit(ResourceState.Loading())

            val response = newsDataSource.getNewsArticles(country)
            if(response.isSuccessful && response.body() != null) {
                emit(ResourceState.Success(response.body()!!))
            } else {
                emit(ResourceState.Error("Failed to fetch news"))
            }
        }.catch {
            emit(ResourceState.Error(it.localizedMessage?: "An unexpected error occurred!"))
        }
    }


    suspend fun getMealItems(country: String): Flow<ResourceState<MealsResponse>> {
        return flow {
            emit(ResourceState.Loading())

            val response = mealDataSource.getMealItems(country)
            if(response.isSuccessful && response.body() != null) {
                emit(ResourceState.Success(response.body()!!))
            } else {
                emit(ResourceState.Error("Failed to fetch news"))
            }
        }.catch {
            emit(ResourceState.Error(it.localizedMessage?: "An unexpected error occurred!"))
        }
    }
}