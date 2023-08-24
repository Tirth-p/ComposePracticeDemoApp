package com.example.composepracticedemoapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.tooling.preview.Preview
import com.example.composepracticedemoapp.ui.theme.ComposePracticeDemoAppTheme
import com.example.composepracticedemoapp.ui.theme.DeepBlue
import com.google.accompanist.systemuicontroller.rememberSystemUiController

class MeditationUi : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val systemBarColor = DeepBlue
            val systemUiController = rememberSystemUiController()

            // Change status bar color
            SideEffect {
                systemUiController.setStatusBarColor(
                    color = systemBarColor,
                    darkIcons = true
                )
            }

            // Change navigation bar color
            SideEffect {
                systemUiController.setNavigationBarColor(
                    color = systemBarColor,
                    darkIcons = true
                )
            }
            ComposePracticeDemoAppTheme {
                HomeMeditation()
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview8() {
    ComposePracticeDemoAppTheme {
        HomeMeditation()
    }
}
