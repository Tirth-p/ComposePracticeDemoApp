package com.example.composepracticedemoapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composepracticedemoapp.ui.theme.ComposePracticeDemoAppTheme

class ListCompose : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposePracticeDemoAppTheme {
//                ColumnScrollable()
//                LazyColumnList()
                LazyColumnListIndex()
            }
        }
    }
}

@Composable
fun ColumnScrollable() {
    // Make row or column scrollable 
    val scrollableState = rememberScrollState()
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .verticalScroll(scrollableState)
            .fillMaxSize()
            .padding(vertical = 10.dp)
    ) {
        for (i in 1..50)
            Text(text = "Hello $i")

    }
}

@Composable
fun LazyColumnList() {
    LazyColumn {
        items(500) {
            Text(
                text = "Hello $it",
                textAlign = TextAlign.Center,
                fontSize = 24.sp,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(18.dp)
            )
        }
    }
}

@Composable
fun LazyColumnListIndex() {
    LazyColumn {
        // If we can pass list as a parameter we have access to index and list here
        itemsIndexed(
            listOf(
                "Apple", "Banana", "Orange", "Grapes", "Mango",
                "Strawberry", "Watermelon", "Pineapple", "Kiwi", "Peach",
                "Cherry", "Blueberry", "Raspberry", "Blackberry", "Lemon",
                "Pear", "Coconut", "Avocado", "Pomegranate", "Guava",
                "Fig", "Plum", "Apricot", "Cantaloupe", "Lime",
                "Lychee", "Dragon Fruit", "Passion Fruit", "Persimmon", "Papaya",
                "Mangosteen", "Honeydew", "Cranberry", "Mulberry", "Elderberry",
                "Gooseberry", "Rambutan", "Star Fruit", "Tangerine", "Kumquat",
                "Carambola", "Nectarine", "Quince", "Durian", "Jack-fruit"
            )
        ) {index, name ->
            Text(
                text = "Hello $name + $index",
                textAlign = TextAlign.Center,
                fontSize = 24.sp,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(18.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview4() {
    ComposePracticeDemoAppTheme {
//        ColumnScrollable()
//        LazyColumnList()
        LazyColumnListIndex()
    }
}