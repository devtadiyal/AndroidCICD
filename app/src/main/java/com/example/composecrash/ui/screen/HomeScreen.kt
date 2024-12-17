package com.example.composecrash.ui.screen

import android.util.Log
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.composecrash.data.ResourceState
import com.example.composecrash.ui.components.HorizontalPagerScreen
import com.example.composecrash.ui.components.VerticalPagerScreen
import com.example.composecrash.ui.viewmodel.NewsViewModel

const val TAG = "NewsApplication"

@Composable
fun HomeScreen(newsViewModel: NewsViewModel = hiltViewModel()) {
    val newsResponse = newsViewModel.news.collectAsState()
    val mealsResponse = newsViewModel.meals.collectAsState()
    
    
    when (newsResponse.value) {
        is ResourceState.Loading -> {
            // Show loading
            //Loader()
            Log.d(TAG, "HomeScreen: Loading")
        }

        is ResourceState.Success -> {
            // Show success
            val response = (newsResponse.value as ResourceState.Success).data
            VerticalPagerScreen(response = response)
            //HorizontalPagerScreen(response)
            //LazyVerticalList(response)
            Log.d(TAG, "HomeScreen: Success " + response.status + "   " + response.totalResults)
        }

        is ResourceState.Error -> {
            // Show error
            val error = (newsResponse.value as ResourceState.Error).message
            Log.d(TAG, "HomeScreen: Error $error")
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun HomeScreenPreview() {
    Surface(
        modifier = Modifier
            .fillMaxSize(),
        color = Color.White
    ) {
    }
}