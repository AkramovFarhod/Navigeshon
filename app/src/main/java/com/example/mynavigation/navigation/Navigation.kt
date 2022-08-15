package com.example.mynavigation.navigation

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination

import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.mynavigation.R
import com.example.mynavigation.screens.HomeScreen
import com.example.mynavigation.screens.PersonScreen
import com.example.mynavigation.ui.Bookmarks
import com.example.mynavigation.ui.Home
import com.example.mynavigation.ui.Person


@Composable
fun BottomNavHost(modifier: Modifier,navHostController: NavHostController) {
    val navController = rememberNavController()
    NavHost(
        modifier = modifier,
        navController = navHostController,
        startDestination = Screens.Home.route
    ) {
        composable(route = Screens.Home.route) {
            HomeScreen(navController = navController)
        }
        composable(route = Screens.Favorite.route) {
            Bookmarks()
        }
        composable(route = Screens.Add.route) {
            PersonScreen()
        }
    }
}


@Composable
fun BottomNavigationScreen(navController: NavController, items: List<Screens>) {

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination
    BottomNavigation {
        items.forEach { screens ->
            BottomNavigationItem(
                modifier = Modifier.background(if(currentDestination?.route == screens.route) Color.Blue else Color.White),
                selected = currentDestination?.route == screens.route,
                onClick = {
                    navController.navigate(screens.route) {
                        popUpTo(navController.graph.findStartDestination().id)

                    }
                },
                icon = {
                    Icon(
                        painter = painterResource(id = screens.icons),
                        contentDescription = null)
                },
                label = { Text(text = screens.title) },
                alwaysShowLabel = false,
                selectedContentColor = Color.White,
                unselectedContentColor = Color.Blue
            )
        }
    }
}


