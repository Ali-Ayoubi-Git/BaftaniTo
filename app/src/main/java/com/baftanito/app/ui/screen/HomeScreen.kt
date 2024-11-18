package com.baftanito.app.ui.screen

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
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.baftanito.app.models.site.Slider
import com.baftanito.app.viewmodels.site.SliderViewModel
import com.skydoves.landscapist.glide.GlideImage

@Composable
fun HomeScreen(navController: NavHostController) {

    Column(
        Modifier.padding(20.dp)
    ) {
        SliderListView()
    }
}


@Composable
fun SliderListView(viewModel: SliderViewModel = hiltViewModel()) {

    var dataList by remember { mutableStateOf(viewModel.dataList) }
    LazyRow {
        items(dataList.value.size) { index ->
            SliderItemView(dataList.value[index])
            Spacer(modifier = Modifier.width(10.dp))
        }
    }
}

@Composable
fun SliderItemView(slider: Slider) {
    Card(
        modifier = Modifier
            .width(300.dp)
            .height(200.dp)
            .shadow(elevation = 8.dp,
                shape = RoundedCornerShape(16.dp),
                clip = true),
        shape = RoundedCornerShape(20.dp),
        onClick = {/*TODO*/}
    ) {
        GlideImage(
            imageModel = { slider.image!! },
            loading = {
                CircularProgressIndicator()
            },
            failure = {
                Text(text = "image request failed")
            }
        )
    }

}