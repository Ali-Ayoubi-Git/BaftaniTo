package com.onlineShop.app.ui.screen

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.onlineShop.app.ui.components.LoadingInColumn
import com.onlineShop.app.ui.components.LoadingInRow
import com.onlineShop.app.ui.components.product.ProductListItemView
import com.onlineShop.app.viewmodels.products.ProductByCategoryViewModel

@Composable
fun ProductsScreen(
    it: Long,
    title: String?,
    navController: NavHostController,
    viewModel: ProductByCategoryViewModel = hiltViewModel()


) {
    var dataList by remember { mutableStateOf(viewModel.dataList) }
    var isLoading by remember { mutableStateOf(viewModel.isLoading) }

    LazyColumn {
        item {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(top = 0.dp, bottom = 0.dp),

                ) {
                IconButton(onClick = { navController.popBackStack() }) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = "BACK",
                        tint = Color.White
                    )
                }
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 0.dp, end = 36.dp),
                    text = title!!,
                    fontSize = 26.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    color = if (isSystemInDarkTheme()) Color.White else Color.Black,
                )
            }
        }
        items(dataList.value.size) { index ->
            viewModel.onScrollPositionChange(index)
            if ((index + 1) >= (viewModel.pageIndex.value * viewModel.pageSize) && viewModel.isLoading.value) {

                viewModel.nextPage()
            }

            ProductListItemView(dataList.value[index], navController)
            Spacer(modifier = Modifier.heightIn(10.dp))
        }
        if (isLoading.value) {
            item {
                LoadingInColumn(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(200.dp)
                )
            }
        }
    }
}




