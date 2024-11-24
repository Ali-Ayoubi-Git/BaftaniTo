package com.onlineShop.app.viewmodels.site

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.onlineShop.app.models.site.Content
import com.onlineShop.app.repositories.site.ContentRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import com.onlineShop.app.models.ServiceResponse
import javax.inject.Inject

@HiltViewModel
class ContentViewModel @Inject constructor(
    private val repository: ContentRepository
) : ViewModel() {

    fun getContent(onResponse: (response: ServiceResponse<Content>) -> Unit) {
        viewModelScope.launch {
            var response = repository.getContent()
            onResponse(response)
        }
    }

    fun getContentByTitle(title: String, onResponse: (response: ServiceResponse<Content>) -> Unit) {
        viewModelScope.launch {
            var response = repository.getContentByTitle(title)
            onResponse(response)
        }
    }
}