package com.onlineShop.app.ui.screen

import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.onlineShop.app.ui.components.LoadingInColumn
import com.onlineShop.app.ui.components.LoadingInRow
import com.onlineShop.app.viewmodels.products.ProductViewModel

import com.skydoves.landscapist.glide.GlideImage
import java.util.Locale

@Composable
fun ShowProductScreen(
    productId: Long,
    navController: NavHostController,
    viewModel: ProductViewModel = hiltViewModel(),

) {

    val data by remember { mutableStateOf(viewModel.data) }
    var isLoading by remember { mutableStateOf(true) }
    val context = LocalContext.current
    var selectedSize by remember { mutableIntStateOf(0) }
    var selectedColor by remember { mutableIntStateOf(0) }


    viewModel.getProductById(productId) { responce ->
        isLoading = false
        if (responce.status == "OK") {
            if (responce.data!!.isNotEmpty()) {
                viewModel.data.value = responce.data!![0]
            } else {
                Toast.makeText(context, "Error on load data!!", Toast.LENGTH_LONG).show()
                navController.popBackStack()
            }
        }
    }
    if (isLoading) {
        LoadingInColumn(modifier = Modifier.fillMaxSize())
    } else {
        Box(
            modifier = Modifier
                .fillMaxSize(),
        ) {
            Box {
                GlideImage(
                    modifier = Modifier.fillMaxSize(),
                    imageModel = { data.value!!.image!! },
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
            }
            //حاله ای از رنگ مشکی تا بی رنگ روی کل صفحه
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        brush = Brush.verticalGradient(
                            colors = listOf(
                                Color.Transparent,
                                Color.Black
                            )
                        )
                    )
            )
            //دکمه برگشت
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(0.dp),
                contentAlignment = Alignment.BottomStart
            ) {
                IconButton(onClick = { navController.popBackStack() }) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = "BACK",
                        tint = Color.White
                    )
                }
            }

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(20.dp),
                contentAlignment = Alignment.BottomStart
            ) {
                Column() {
                    //نام
                    Text(
                        text = data.value!!.title!!,
                        color = Color.White,
                        fontSize = 25.sp,
                        fontWeight = FontWeight.Bold
                    )
                    //قیمت
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = "${data.value!!.price!!} IRT",
                        color = Color.White,
                        fontSize = 25.sp,
                    )
                    //سایز
                    Spacer(modifier = Modifier.height(20.dp))
                    Text(
                        text = "Sizes",
                        color = Color.White,
                        fontSize = 26.sp,
                        fontWeight = FontWeight.Bold
                    )
                    //سایز ها
                    Spacer(modifier = Modifier.height(10.dp))
                    LazyRow {
                        items(data.value!!.sizes!!.size) { index ->
                            TextButton(
                                onClick = { selectedSize = index },
                                shape = RoundedCornerShape(15.dp),
                                colors = ButtonDefaults.buttonColors(
                                    if (selectedSize == index) Color.White
                                    else Color.DarkGray
                                ),
                                modifier = Modifier.size(40.dp)
                            ) {
                                Text(
                                    text = data.value!!.sizes!![index].title!! + "1",
                                    fontWeight = FontWeight.Bold,
                                    color = if (selectedSize == index) Color.Black
                                    else Color.White
                                )
                            }
                            Spacer(modifier = Modifier.width(5.dp))
                        }
                    }
                    //رنگ
                    Spacer(modifier = Modifier.height(22.dp))
                    Text(
                        text = "Colors",
                        color = Color.White,
                        fontSize = 26.sp,
                        fontWeight = FontWeight.Bold
                    )
                    //رنگ ها
                    Spacer(modifier = Modifier.height(10.dp))
                    LazyRow {
                        items(data.value!!.colors!!.size) { index ->
                            TextButton(
                                onClick = { selectedColor = index },
                                shape = RoundedCornerShape(50.dp),
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = Color(
                                        android.graphics.Color.parseColor(
                                            "#${data.value!!.colors!![index].hexValue}"
                                        )
                                    )
                                ),
                                modifier = Modifier.size(40.dp),
                                border = BorderStroke(1.dp, Color.White),

                                ) {
                                if (selectedColor == index) {
                                    Icon(
                                        imageVector = Icons.Filled.Check,
                                        contentDescription = "CHECK",
                                        tint = if (data.value!!.colors!![index].hexValue?.toLowerCase(
                                                Locale.ROOT
                                            ) == "ffffff"
                                        ) {
                                            Color.Black

                                        } else {
                                            Color.White
                                        }
                                    )
                                }
                            }
                            Spacer(modifier = Modifier.width(5.dp))
                        }
                    }
                    //خرید
                    Spacer(modifier = Modifier.height(45.dp))
                    Button(
                        onClick = {/*TODO*/ },
                        shape = RoundedCornerShape(15.dp),
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.White
                        )
                    ) {
                        Text(text = "Buy Now", fontWeight = FontWeight.Bold)
                    }

                }
            }
        }
    }
}
