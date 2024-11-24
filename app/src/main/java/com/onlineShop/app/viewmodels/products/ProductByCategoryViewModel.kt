package com.onlineShop.app.viewmodels.products

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.onlineShop.app.models.products.Product
import com.onlineShop.app.repositories.products.ProductRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import com.onlineShop.app.models.ServiceResponse
import com.onlineShop.app.utils.ThisApp
import javax.inject.Inject

@HiltViewModel
class ProductByCategoryViewModel @Inject constructor(
    private val repository: ProductRepository
) : ViewModel() {

    var categoryId: Long = ThisApp.productCategoryId
    var pageSize = 3
    var pageIndex = mutableStateOf(0)
    private var scrollPosition = 0

    var dataList = mutableStateOf<List<Product>>(listOf())
    var isLoading = mutableStateOf(true)

    init {
        getProductsByCategoryId(categoryId, pageIndex.value, pageSize) { response ->
            isLoading.value = false
            if (response.status == "OK") {
                dataList.value = response.data!!
            }
        }
    }

    fun getProductsByCategoryId(
        categoryId: Long,
        pageIndex: Int,
        pageSize: Int,
        onResponse: (response: ServiceResponse<Product>) -> Unit
    ) {
        viewModelScope.launch {
            var response = repository.getProductsByCategoryId(categoryId, pageIndex, pageSize)
            onResponse(response)
        }
    }

    fun incrementPage() {
        pageIndex.value = pageIndex.value + 1
    }

    fun onScrollPositionChange(position: Int) {
        scrollPosition = position
    }

    fun appendItems(items: List<Product>) {
        var current = ArrayList(dataList.value)
        current.addAll(items)
        dataList.value = current
    }

    fun nextPage() {
        viewModelScope.launch {
            if ((scrollPosition + 1) >= (pageIndex.value * pageSize)) {
                isLoading.value = true
                incrementPage()
                if (pageIndex.value > 0) {
                    getProductsByCategoryId(categoryId, pageIndex.value, pageSize) { response ->
                        if (response.status == "OK" && response.data!!.isNotEmpty()) {
                            appendItems(response.data!!)
                        }
                        isLoading.value = false
                    }
                }
            }
        }
    }
}