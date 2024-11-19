package com.baftanito.app.ui.components.product

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ProductListByFilter() {
    Column {
        ProductFilterView()
        Spacer(modifier = Modifier.width(20.dp))
        LazyRow {
            items(1) { index ->
                ProductListItemView()
            }
        }


    }

}



