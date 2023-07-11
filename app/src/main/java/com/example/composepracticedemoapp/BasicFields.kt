package com.example.composepracticedemoapp

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composepracticedemoapp.ui.theme.ComposePracticeDemoAppTheme
import kotlinx.coroutines.launch

class BasicFields : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposePracticeDemoAppTheme {
                SnackBarTextField()
            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun SnackBarTextField() {
    val context = LocalContext.current
    val snackBarHoldState = remember {
        SnackbarHostState()
    }
    var textFieldState by remember {
        mutableStateOf("")
    }
    val scope = rememberCoroutineScope()


    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF101010))
    ) {
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            snackbarHost = {
                SnackbarHost(hostState = snackBarHoldState)
            },
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 16.dp)
            ) {
                Text(
                    buildAnnotatedString {
                        withStyle(
                            style = SpanStyle(
                                color = Color.Green,
                                fontSize = 35.sp,
                                textDecoration = TextDecoration.Underline
                            )
                        ) {
                            append("S")
                        }
                        append("nackba")
                        withStyle(
                            style = SpanStyle(
                                color = Color.Green,
                                fontSize = 35.sp,
                                textDecoration = TextDecoration.Underline
                            )
                        ) {
                            append("R")
                        }
                    },
                    textDecoration = TextDecoration.Underline,
                    fontSize = 20.sp,
                    color = Color.Black,
                    modifier = Modifier
                        .clickable{}
                        .pointerInput(Unit) {
                        detectTapGestures(
                            onLongPress = {
                                context.startActivity(Intent( context,ListCompose::class.java))
                            }
                        )
            }
                )

                Spacer(modifier = Modifier.height(16.dp))

                TextField(value = textFieldState,
                    label = {
                        Text(text = "Enter Your Name")
                    }, onValueChange = {
                        textFieldState = it
                    },
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(16.dp))
                Button(onClick = {
                    if (textFieldState == "tirth") {
                        context.startActivity(Intent(context, ListCompose::class.java))
                    } else {
                        scope.launch {
                            snackBarHoldState.showSnackbar("Hello $textFieldState")
                        }
                    }
                }) {
                    Text(text = "Click Here")
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview3() {
    ComposePracticeDemoAppTheme {
        SnackBarTextField()
    }
}
