package com.example.composepracticedemoapp

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.composepracticedemoapp.data.BottomNavItem
import com.example.composepracticedemoapp.ui.theme.ComposePracticeDemoAppTheme

class BadgesBottomNavBar : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposePracticeDemoAppTheme {
                BottomNavBar()
            }
        }
    }
}


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomNavBar() {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = {
            BottomNavigationBar(
                items = listOf(
                    BottomNavItem(
                        name = "Home",
                        route = "home",
                        checkedIcon = Icons.Filled.Home,
                        uncheckedIcon = Icons.Outlined.Home
                    ),
                    BottomNavItem(
                        name = "Chat",
                        route = "chat",
                        checkedIcon = Icons.Filled.Notifications,
                        uncheckedIcon = Icons.Outlined.Notifications,
                        badgeCount = 10
                    ),
                    BottomNavItem(
                        name = "Settings",
                        route = "settings",
                        checkedIcon = Icons.Filled.Settings,
                        uncheckedIcon = Icons.Outlined.Settings
                    ),
                ),
                navController = navController,
                OnItemClick = {
                    navController.navigate(it.route)
                }
            )
        }
    ) {
        Navigation(navHostController = navController)
    }
}

@Composable
private fun Navigation(navHostController: NavHostController) {
    NavHost(navController = navHostController, startDestination = "home") {
        composable("home") {
            HomeScreenBar()
        }
        composable("chat") {
            ChatScreen()
        }
        composable("settings") {
            SettingScreen()
        }
    }
}


@Composable
fun BottomNavigationBar(
    items: List<BottomNavItem>,
    navController: NavController,
    modifier: Modifier = Modifier,
    OnItemClick: (BottomNavItem) -> Unit,
) {

    val backStackEntry = navController.currentBackStackEntryAsState()
    NavigationBar(
        modifier = Modifier,
        tonalElevation = 5.dp,
    ) {
        items.forEach { item ->
            val selected = item.route == backStackEntry.value?.destination?.route
            NavigationBarItem(
                selected = selected,
                onClick = {
                    OnItemClick(item)
                },
                label = { Text(text = item.name) },
                interactionSource = remember { MutableInteractionSource() },
                colors = NavigationBarItemDefaults.colors(),
                icon = {
                    Column(horizontalAlignment = CenterHorizontally) {
                        if (item.badgeCount > 0) {
                            BadgedBox(badge = {
                                Badge { Text(text = item.badgeCount.toString()) }
                            }
                            ) {
                                if (selected) {
                                    Icon(
                                        imageVector = item.checkedIcon,
                                        contentDescription = item.name
                                    )
                                } else {
                                    Icon(
                                        imageVector = item.uncheckedIcon,
                                        contentDescription = item.name
                                    )
                                }
                            }
                        } else {
                            if (selected) {
                                Icon(
                                    imageVector = item.checkedIcon,
                                    contentDescription = item.name
                                )
                            } else {
                                Icon(
                                    imageVector = item.uncheckedIcon,
                                    contentDescription = item.name
                                )
                            }
                        }
                    }
                }
            )
        }
    }
}


@Composable
fun HomeScreenBar() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "Home Screen")
    }
}

@Composable
fun ChatScreen() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "Chat Screen")
    }
}

@Composable
fun SettingScreen() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "Setting Screen")
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview10() {
    ComposePracticeDemoAppTheme {
        BottomNavBar()
    }
}