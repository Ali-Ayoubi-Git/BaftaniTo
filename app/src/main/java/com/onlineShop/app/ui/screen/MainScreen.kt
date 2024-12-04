package com.onlineShop.app.ui.screen

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.onlineShop.app.MainActivity
import com.onlineShop.app.db.viewmodels.BasketEntityViewModel
import com.onlineShop.app.utils.ThisApp


@Composable
fun MainScreen(mainActivity: MainActivity) {
    val navController = rememberNavController()

    Scaffold {

        NavHost(
            modifier = Modifier.padding(it),
            navController = navController,
            startDestination = "home"
        ) {
            composable("home") {
                HomeScreen(navController)
            }
            //نمایش دستبه بندی محصولات مربوطه
            composable(
                "products/{categoryId}/{title}",
                arguments = listOf(
                    navArgument("categoryId") { type = NavType.LongType },
                    navArgument("title") { type = NavType.StringType },
                )
            ) { backStack ->
                val id = backStack.arguments?.getLong("categoryId")
                val title = backStack.arguments?.getString("title")
                ThisApp.productCategoryId = id!!
                ProductsScreen(id!!, title!!, navController)

            }
            //نمایش صفحه خود محصول
            composable(
                "showProduct/{productId}",
                arguments = listOf(
                    navArgument("productId") { type = NavType.LongType }
                )
            ) { backStack ->
                backStack.arguments?.getLong("productId").let {
                    val basketViewModel = ViewModelProvider(mainActivity).get(BasketEntityViewModel::class.java)
                    ShowProductScreen(it!!, navController,basketViewModel)

                }
            }
        }
    }


}

