package com.onlineShop.app.viewmodels.site

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.onlineShop.app.models.site.Blog
import com.onlineShop.app.repositories.site.BlogRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import com.onlineShop.app.models.ServiceResponse
import javax.inject.Inject

@HiltViewModel
class BlogViewModel @Inject constructor(
    private val repository: BlogRepository
) : ViewModel() {

    fun getBlogs(onResponse: (response: ServiceResponse<Blog>) -> Unit) {
        viewModelScope.launch {
            var response = repository.getBlog()
            onResponse(response)
        }
    }

    fun getBlogById(id: Long, onResponse: (response: ServiceResponse<Blog>) -> Unit) {
        viewModelScope.launch {
            var response = repository.getBlogById(id)
            onResponse(response)
        }
    }
}