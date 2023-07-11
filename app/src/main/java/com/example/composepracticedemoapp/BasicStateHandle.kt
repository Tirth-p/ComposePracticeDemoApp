package com.example.composepracticedemoapp

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.example.composepracticedemoapp.ui.theme.ComposePracticeDemoAppTheme
import kotlin.random.Random

class BasicStateHandle : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposePracticeDemoAppTheme {
                ShowBox()
            }
        }
    }
}

@Composable
fun ShowBox() {
    val context = LocalContext.current
    val color = remember {
        mutableStateOf(Color.Yellow)
    }
    Column(modifier = Modifier.fillMaxSize()) {
        ColorBox(
            modifier = Modifier
                .weight(1f)
                .fillMaxSize()
        ) {
            color.value = it
        }

        Box(
            modifier = Modifier
                .weight(1f)
                .background(color.value)
                .fillMaxSize()
                .clickable { }
                .pointerInput(Unit) {
                    detectTapGestures(
                        onDoubleTap = {
                            context.startActivity(Intent(context, BasicFields::class.java))
                        }
                    )
                }
        )
    }
}

@Composable
fun ColorBox(
    modifier: Modifier = Modifier,
    updateColor: (Color) -> Unit,
) {
    val color = remember {
        mutableStateOf(Color.Blue)
    }


    Box(modifier = modifier
        .background(color.value)
        .clickable {
            updateColor(
                Color(
                    Random.nextFloat(),
                    Random.nextFloat(),
                    Random.nextFloat(),
                    1f
                )
            )
        }
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview2() {
    ComposePracticeDemoAppTheme {
        ShowBox()
    }
}