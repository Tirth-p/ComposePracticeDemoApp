package com.example.composepracticedemoapp

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateColor
import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composepracticedemoapp.ui.theme.ComposePracticeDemoAppTheme

class SimpleAnimation : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposePracticeDemoAppTheme {
                SimpleAnimationBox()
            }
        }
    }
}

@Composable
fun SimpleAnimationBox() {
    val context = LocalContext.current
    var sizeState by remember {
        mutableStateOf(200.dp)
    }

    val size by animateDpAsState(targetValue = sizeState)
    val tweenAnim by animateDpAsState(
        targetValue = sizeState,
        tween(
            durationMillis = 2000,
            delayMillis = 200,
            easing = LinearOutSlowInEasing
        )
    )
    val springAnim by animateDpAsState(
        targetValue = sizeState,
        spring(
            Spring.DampingRatioHighBouncy
        )
    )
    val keyFramesAnim by animateDpAsState(targetValue = sizeState,
        keyframes {
            durationMillis = 2000
            sizeState at 0 with LinearEasing
            sizeState * 1.5f at 1000 with FastOutLinearInEasing
            sizeState * 2f at 5000
        }
    )
    // Color Animation
    val infiniteTransition = rememberInfiniteTransition()
    val color by infiniteTransition.animateColor(
        initialValue = Color.Red,
        targetValue = Color.Green,
        animationSpec = infiniteRepeatable(
            tween(durationMillis = 2000),
            repeatMode = RepeatMode.Reverse
        )
    )

    Box(
        modifier = Modifier
            .size(keyFramesAnim)
            .background(color),
        contentAlignment = Alignment.Center
    ) {
        Column {
            Button(onClick = {
                if (sizeState == 800.dp)
                    Toast.makeText(context, "Max Size", Toast.LENGTH_SHORT).show()
                else
                    sizeState += 50.dp

            }) {
                Text(text = "Increase Size")
            }
            Button(onClick = {
                if (sizeState == 150.dp)
                    Toast.makeText(context, "Min Size", Toast.LENGTH_SHORT).show()
                else
                    sizeState -= 50.dp

            }) {
                Text(text = "Decrease Size")
            }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview6() {
    ComposePracticeDemoAppTheme {
        SimpleAnimationBox()
    }
}