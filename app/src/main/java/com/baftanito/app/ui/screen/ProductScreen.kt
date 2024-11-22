package com.baftanito.app.ui.screen

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.baftanito.app.viewmodels.products.ProductViewModel

@Composable
fun ProductScreen(
    it: Long,
    navController: NavHostController,
    viewModel: ProductViewModel = hiltViewModel(),
    isFullScreen: Boolean
) {

}