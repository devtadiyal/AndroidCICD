package com.example.composecrash

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.example.composecrash.ui.navigation.AppNavigationGraph
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        setContent {
                   // Greeting("Android")
                   // HorizontalView()
                   // VerticalView()
                   // SimpleButton()
                    //ListComponent()
            Surface(
                modifier = Modifier
                    .fillMaxSize(),
                color = Color.White
            ) {
                AppEntryPoint()
            }
        }
    }
}

@Composable
fun AppEntryPoint() {
    AppNavigationGraph()
}