package com.example.composepracticedemoapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composepracticedemoapp.data.ListItemForMultiSelect
import com.example.composepracticedemoapp.ui.theme.ComposePracticeDemoAppTheme

class MultiSelectLazyColumn : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposePracticeDemoAppTheme {
                LazyColumnSelect()
            }
        }
    }
}

@Composable
fun LazyColumnSelect() {
    var items by remember {
        mutableStateOf(
            (1..20).map {
                ListItemForMultiSelect(
                    title = "item $it",
                    isSelect = false
                )
            }
        )
    }
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(items.size) { i ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable {
                        items = items.mapIndexed { j, item ->
                            if (i == j) {
                                item.copy(isSelect = !item.isSelect)
                            } else item
                        }
                    }
                    .padding(16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = items[i].title)
                if (items[i].isSelect) {
                    Icon(
                        imageVector = Icons.Default.Check,
                        contentDescription = "Selected",
                        tint = Color.Green,
                        modifier = Modifier.size(20.dp)
                    )
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview13() {
    ComposePracticeDemoAppTheme {
        LazyColumnSelect()
    }
}