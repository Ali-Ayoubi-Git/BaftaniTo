package com.baftanito.app.ui.screen

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.baftanito.app.ui.components.TopAppView


@Preview
@Composable
fun MainScreen() {
    val navController = rememberNavController()
    val currentRoute = navController.currentBackStackEntryFlow.collectAsState(initial = null)

    Scaffold(
        topBar = {
            val route = currentRoute.value?.destination?.route
            if (route == "home") {
                TopAppView()}
        }

    ) {
        NavHost(
            modifier = Modifier.padding(it),
            navController = navController,

            startDestination = "home"
        ) {
            composable("home") {
                HomeScreen(navController)
            }
            composable("viewCozy") {
                HomeScreen(navController)

            }
            composable("shopping") {
                HomeScreen(navController)

            }
            composable("person") {
                HomeScreen(navController)

            }
            composable(
                "showProduct/{productId}",
                arguments = listOf(
                    navArgument("productId") { type = NavType.LongType }
                )
            ) { backStack ->
               // fullScreen = true
               backStack.arguments?.getLong("productId").let {
                    ShowProductScreen(it!!,navController,isFullScreen = true)

                }


            }
        }
    }
}