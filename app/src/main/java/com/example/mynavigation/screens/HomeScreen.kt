package com.example.mynavigation.screens

import android.content.Intent
import android.widget.Toast
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import com.example.mynavigation.navigation.Screens
import com.example.mynavigation.ui.Home

@Composable
fun HomeScreen(navController: NavController) {
    val context = LocalContext.current
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = { navController.navigate(Screens.Add.route)}) {
                IconButton(onClick = {
                    Toast.makeText(context,"Add", Toast.LENGTH_SHORT).show()
                   // context.startActivity(Intent(context, Screens.Add::class.java))
                }) {

                }
                Text(text = "+")
            }
        },
        floatingActionButtonPosition = FabPosition.End

    ) {

    }
}