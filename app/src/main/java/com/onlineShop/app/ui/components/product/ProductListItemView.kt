package com.onlineShop.app.ui.components.product

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.onlineShop.app.models.products.Product
import com.google.gson.Gson
import com.skydoves.landscapist.glide.GlideImage

@Composable
fun ProductListItemView(product: Product, navController: NavController) {
    Card(
        modifier = Modifier
            .fillMaxSize()
            .width(300.dp)
            .height(200.dp)
            .shadow(
                elevation = 8.dp,
                shape = RoundedCornerShape(14.dp),
                clip = true
            ),
        shape = RoundedCornerShape(16.dp),
        onClick = {
            val productJson= Gson().toJson(product)
            navController.navigate("showProduct/${product.id}")
        }
    ) {
        Box {
            GlideImage(
                modifier = Modifier.fillMaxSize(),
                imageModel = { product.image!! },
                loading = {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(15.dp),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) { CircularProgressIndicator() }
                },
                failure = {
                    Text(text = "image request failed")
                })
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp),
                contentAlignment = Alignment.TopStart
            ) {
                Text(
                    text = product.title!!,
                    color = Color.White,
                    fontSize = 25.sp,
                    fontWeight = FontWeight.Bold
                )


            }
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(20.dp),
                contentAlignment = Alignment.BottomStart
            ) {
                Text(
                    text = "${product.price!!} IRT",
                    color = Color.White,
                    fontSize = 25.sp,
                )
            }
        }
    }
}
