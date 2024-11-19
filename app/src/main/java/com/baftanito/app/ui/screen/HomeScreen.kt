package com.baftanito.app.ui.screen

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.baftanito.app.models.site.Slider
import com.baftanito.app.ui.components.product.ProductCategoryListView
import com.baftanito.app.ui.components.product.ProductListByFilter
import com.baftanito.app.ui.components.slider.SliderItemView
import com.baftanito.app.ui.components.slider.SliderListView
import com.baftanito.app.viewmodels.site.SliderViewModel
import com.skydoves.landscapist.glide.GlideImage

@Composable
fun HomeScreen(navController: NavHostController) {

    Column(
        Modifier.padding(20.dp)
    ) {
        SliderListView()
        Spacer(modifier = Modifier.height(15.dp))
        ProductCategoryListView()
        Spacer(modifier = Modifier.height(15.dp))
        ProductListByFilter()
    }
}



