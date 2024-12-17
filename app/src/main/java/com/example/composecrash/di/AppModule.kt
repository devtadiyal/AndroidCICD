package com.example.composecrash.di

import com.example.composecrash.data.AppConstants
import com.example.composecrash.data.api.ApiService
import com.example.composecrash.data.datasource.MealDataSource
import com.example.composecrash.data.datasource.NewsDataSource
import com.example.composecrash.data.datasource.NewsDataSourceImpl
import com.example.composecrash.ui.repository.NewsRepository
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun providesRetrofit(): Retrofit {
        val httpLoggingInterceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

        val httpClient = OkHttpClient.Builder()
            .apply {
                addInterceptor(httpLoggingInterceptor)
                readTimeout(60, TimeUnit.SECONDS)
                connectTimeout(60, TimeUnit.SECONDS)
            }
            .build()

        val gson = GsonBuilder()
            .setLenient() // Optional: Allows handling malformed JSON
            .create()

        return Retrofit.Builder()
            .baseUrl(AppConstants.BASE_URL)
            .client(httpClient)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }

    @Singleton
    @Provides
    fun provideApiService(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }

    @Singleton
    @Provides
    fun provideNewsDataSource(apiService: ApiService): NewsDataSource {
        return NewsDataSourceImpl(apiService)
    }

    @Singleton
    @Provides
    fun provideMealsDataSource(apiService: ApiService): MealDataSource {
        return NewsDataSourceImpl(apiService)
    }

    @Singleton
    @Provides
    fun provideNewsRepository(newsDataSource: NewsDataSource, mealDataSource: MealDataSource): NewsRepository {
        return NewsRepository(newsDataSource, mealDataSource)
    }
}
