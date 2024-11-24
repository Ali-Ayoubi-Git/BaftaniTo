package com.onlineShop.app.ui.components.product

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.onlineShop.app.viewmodels.products.ProductViewModel

@Composable
fun ProductListByFilter(
    viewModel: ProductViewModel = hiltViewModel(),
    navController: NavHostController,
) {
    var dataList by remember { mutableStateOf(viewModel.dataList) }

    Column {
        ProductFilterView()
        Spacer(modifier = Modifier.width(20.dp))
        LazyRow(modifier = Modifier
            .fillMaxSize()
            .padding()) {
            items(dataList.value.size) { index ->
                ProductListItemView(dataList.value[index], navController)
                Spacer(modifier = Modifier.width(10.dp))

            }
        }
    }
}



