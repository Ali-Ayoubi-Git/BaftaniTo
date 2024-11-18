package com.baftanito.app.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.baftanito.app.ui.components.TopAppView


@Preview
@Composable
fun MainScreen(){
    val navController= rememberNavController()
    Scaffold(
        topBar = {
            TopAppView()
        }

    ) {
        NavHost(
            modifier = Modifier.padding(it),
            navController = navController,

            startDestination = "home"
        ) {
            composable("home"){
                HomeScreen(navController)
            }
            composable("viewCozy"){
                HomeScreen(navController)

            }
            composable("shopping"){
                HomeScreen(navController)

            }
            composable("person"){
                HomeScreen(navController)

            }


        }

    }
}