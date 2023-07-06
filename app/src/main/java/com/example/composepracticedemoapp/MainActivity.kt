package com.example.composepracticedemoapp

import android.os.Bundle
import android.system.Os.stat
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composepracticedemoapp.ui.theme.ComposePracticeDemoAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposePracticeDemoAppTheme {
                SimpleView()
            }
        }
    }
}

@Composable
fun SimpleView() {
    var name by remember {
        mutableStateOf("")
    }
    var names by remember {
        mutableStateOf(listOf<String>())
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Row(modifier = Modifier.fillMaxWidth()) {
            OutlinedTextField(
                modifier = Modifier.weight(1f),
                value = name,
                onValueChange = { text ->
                    name = text
                }
            )
            Spacer(modifier = Modifier.padding(16.dp))
            Button(onClick = {
                if (name.isNotBlank()) {
                    names = names + name
                    name = ""
                }
            }) {
                Text(text = "Add!")
            }
        }
        Divider(modifier = Modifier.padding(0.dp,20.dp))
        Text(
            buildAnnotatedString {
                                 withStyle(
                                     style = SpanStyle(
                                         color = Color.Green,
                                         fontSize = 40.sp
                                     )
                                 ){
                                     append("J")
                                 }
                append("etpack ")
                withStyle(
                    style = SpanStyle(
                        color = Color.Green,
                        fontSize = 40.sp
                    )
                ){
                    append("C")
                }
                append("ompose")
            },
        fontSize = 20.sp,
        color = Color.Black)

        Divider(modifier = Modifier.padding(0.dp,20.dp))

        LazyColumn{
            items(names) { currentName ->
                Text(
                    text = currentName,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                )
                Divider()
            }
        }
    }

}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposePracticeDemoAppTheme {
        SimpleView()
    }
}