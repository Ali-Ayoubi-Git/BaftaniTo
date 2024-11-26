package com.onlineShop.app.ui.screen

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFrom
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
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
import com.onlineShop.app.models.products.Product
import com.onlineShop.app.ui.components.Loading
import com.onlineShop.app.ui.components.product.ProductListItemView
import com.onlineShop.app.viewmodels.products.ProductViewModel

@Composable
fun ProductsScreen(
    it: Long,
    title: String?,
    navController: NavHostController,
    viewModel: ProductViewModel = hiltViewModel()


) {
    var dataList by remember { mutableStateOf<List<Product>>(listOf()) }
    var isLoading by remember { mutableStateOf(true) }

    viewModel.getProductsByCategoryId(it, 0, 10) { response ->
        isLoading = false
        if (response.status == "OK") {
            dataList = response.data!!
        }
    }

    if (isLoading) {
        Loading(
            modifier = Modifier
                .fillMaxSize()
                .height(200.dp)
        )
    } else {

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
                        modifier = Modifier.fillMaxWidth().padding(start = 0.dp, end = 36.dp) ,
                        text = title!!,
                        fontSize = 26.sp,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center,
                        color = if (isSystemInDarkTheme()) Color.White else Color.Black,
                    )

                }
            }


            items(dataList.size) { index ->
                Spacer(modifier = Modifier.heightIn(10.dp))
                ProductListItemView(dataList[index], navController)
                Spacer(modifier = Modifier.heightIn(10.dp))
            }
        }
    }
}


