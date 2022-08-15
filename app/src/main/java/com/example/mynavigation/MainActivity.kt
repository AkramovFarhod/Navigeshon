package com.example.mynavigation

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.core.app.ActivityCompat
import androidx.navigation.compose.rememberNavController
import com.example.mynavigation.navigation.BottomNavHost
import com.example.mynavigation.navigation.BottomNavigationScreen
import com.example.mynavigation.navigation.Screens
import com.example.mynavigation.ui.theme.MyNavigationTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val hasLocationPermission = ActivityCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED

            if (hasLocationPermission) {
                // handle location update
            } else {
                ActivityCompat.requestPermissions(this,
                    arrayOf(Manifest.permission.ACCESS_COARSE_LOCATION), RESULT_FIRST_USER)
            }

            val hasForegroundLocationPermission = ActivityCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED

            if (hasForegroundLocationPermission) {
                val hasBackgroundLocationPermission = ActivityCompat.checkSelfPermission(this,
                    Manifest.permission.ACCESS_BACKGROUND_LOCATION) == PackageManager.PERMISSION_GRANTED

                if (hasBackgroundLocationPermission) {
                    // handle location update
                } else {
                    ActivityCompat.requestPermissions(this,
                        arrayOf(Manifest.permission.ACCESS_BACKGROUND_LOCATION), RESULT_CANCELED)
                }
            } else {
                ActivityCompat.requestPermissions(this,
                    arrayOf(Manifest.permission.ACCESS_COARSE_LOCATION,
                        Manifest.permission.ACCESS_BACKGROUND_LOCATION), RESULT_CANCELED)
            }






            val ListItems = listOf(
                Screens.Home,
                Screens.Favorite,
                Screens.Add,
            )
            val navController = rememberNavController()
            MyNavigationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background


                ) {
                    Scaffold(bottomBar = {
                        BottomNavigationScreen(
                            navController = navController,
                            items = ListItems)
                    }) {
                        BottomNavHost(modifier = Modifier.padding(
                            it
                        ), navHostController = navController)
                    }
                }

            }
        }
    }
}




