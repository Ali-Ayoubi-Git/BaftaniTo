package com.baftanito.app.ui.components.product

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.baftanito.app.viewmodels.products.ProductViewModel


@Composable
fun ProductFilterView(
    viewModel: ProductViewModel= hiltViewModel()
) {
    val filters = listOf("All", "New", "Popular", "Men", "Women", "Style")
    var selectedFilter by remember { mutableIntStateOf(0) }


    LazyRow {
        items(filters.size) { index ->
            TextButton(
                onClick = {
                    selectedFilter = index
                    when (selectedFilter) {
                        0 -> {
                            viewModel.getProducts(0,6){}
                        }

                        1 -> {
                            viewModel.getNewProducts{}
                        }

                        2 -> {
                            viewModel.getPopularProducts{}
                        }
                        // 3->{}
                        //  4->{}
                        //  5->{}
                    }
                },
                colors = ButtonDefaults.buttonColors(
                    if (selectedFilter == index) Color.LightGray
                    else Color.Transparent
                ),
                modifier = Modifier.width(90.dp),
                shape = RoundedCornerShape(20.dp)
            ) {
                Text(
                    text = filters[index],
                    color = Color.DarkGray,
                    fontSize = 15.sp,
                    textAlign = TextAlign.Center
                )
            }
            Spacer(modifier = Modifier.width(10.dp))

        }
    }

}