package com.example.composepracticedemoapp

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.example.composepracticedemoapp.ui.theme.ComposePracticeDemoAppTheme

class HandleButtonCallBack : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposePracticeDemoAppTheme {
                DefaultFunction()
            }
        }
    }
}

@Composable
fun DefaultFunction() {
    val context = LocalContext.current
    ButtonClickHandle(
        buttonList = listOf(
            ButtonList("hello"),
            ButtonList("Hello2"),
            ButtonList("Hello3"),
            ButtonList("Hello4"),
            ButtonList("Hello5"),
            ButtonList("Hello6")
        ),
    )
    {
        Toast.makeText(context, it.name, Toast.LENGTH_SHORT).show()
    }
}


data class ButtonList(val name: String)

@Composable
fun ButtonClickHandle(
    buttonList: List<ButtonList>,
    clickHandle: (ButtonList) -> Unit,
) {
    Column {
        buttonList.forEach { item ->
            Button(
                onClick = { clickHandle(item) }
            ) {
                Text(text = item.name)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview12() {
    ComposePracticeDemoAppTheme {
        DefaultFunction()
    }
}