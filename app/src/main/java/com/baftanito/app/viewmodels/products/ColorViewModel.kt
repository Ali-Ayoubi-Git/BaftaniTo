package com.baftanito.app.viewmodels.products

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import com.baftanito.app.models.ServiceResponse
import com.baftanito.app.models.products.ProductColor
import javax.inject.Inject

@HiltViewModel
class ColorViewModel @Inject constructor(
    private val repository: com.baftanito.app.repositories.products.ColorRepository
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