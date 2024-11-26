package com.onlineShop.app.ui.screen

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.onlineShop.app.ui.components.Loading
import com.onlineShop.app.ui.components.TopAppView
import com.onlineShop.app.ui.components.product.ProductCategoryListView
import com.onlineShop.app.ui.components.product.ProductFilterView
import com.onlineShop.app.ui.components.product.ProductListItemView
import com.onlineShop.app.ui.components.slider.SliderListView
import com.onlineShop.app.viewmodels.products.ProductViewModel

@Composable
fun HomeScreen(
    navController: NavHostController,
    viewModel: ProductViewModel = hiltViewModel()
) {
    val priductList by remember { mutableStateOf(viewModel.dataList) }
    var isLoading by remember { mutableStateOf(viewModel.isLoading) }

    Scaffold(
        topBar = { TopAppView() }
    ) { innerPadding ->
        LazyColumn(
            Modifier.padding(innerPadding)
        ) {
            item {
                SliderListView()
                Spacer(modifier = Modifier.height(15.dp))
                Spacer(modifier = Modifier.width(6.dp))


            }
            item {
                ProductCategoryListView(navController)
                Spacer(modifier = Modifier.height(15.dp))
            }

            item {
                ProductFilterView()
                Spacer(modifier = Modifier.height(20.dp))
            }
            if (isLoading.value) {
                item {
                    Loading(
                        Modifier
                            .fillMaxSize()
                            .height(200.dp)
                    )
                }
            } else {
                items(priductList.value.size) { index ->
                    ProductListItemView(priductList.value[index], navController)
                    Spacer(modifier = Modifier.heightIn(10.dp))
                    Spacer(modifier = Modifier.width(6.dp))

                }
            }
        }
    }
}

