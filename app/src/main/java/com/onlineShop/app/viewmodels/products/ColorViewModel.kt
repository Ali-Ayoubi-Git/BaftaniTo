package com.onlineShop.app.viewmodels.products

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import com.onlineShop.app.models.ServiceResponse
import com.onlineShop.app.models.products.ProductColor
import com.onlineShop.app.repositories.products.ColorRepository
import javax.inject.Inject

@HiltViewModel
class ColorViewModel @Inject constructor(
    private val repository: ColorRepository
) : ViewModel() {

    fun getColors(onResponse: (response: ServiceResponse<ProductColor>) -> Unit) {
        viewModelScope.launch {
            var response = repository.getColors()
            onResponse(response)
        }
    }

    fun getColorById(id: Long, onResponse: (response: ServiceResponse<ProductColor>) -> Unit) {
        viewModelScope.launch {
            var response = repository.getColorById(id)
            onResponse(response)
        }
    }
}