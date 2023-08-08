package com.example.composepracticedemoapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.composepracticedemoapp.ui.theme.ComposePracticeDemoAppTheme

class MultiLayerScroll : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposePracticeDemoAppTheme {
            }
        }
    }
}

@Composable
fun NavigationPractice(navHostController: NavHostController) {
    NavHost(navController = navHostController, startDestination = "code") {
        composable("code") {

        }
        composable("travel") {

        }
        composable("ideate") {

        }
        composable("welcome") {

        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview11() {
    ComposePracticeDemoAppTheme {

    }
}