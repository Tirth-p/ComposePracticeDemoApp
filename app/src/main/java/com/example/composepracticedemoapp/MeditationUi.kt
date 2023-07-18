package com.example.composepracticedemoapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.composepracticedemoapp.ui.theme.ComposePracticeDemoAppTheme

class MeditationUi : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
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
