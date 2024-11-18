package com.baftanito.app.viewmodels.site

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.baftanito.app.models.site.Blog
import com.baftanito.app.repositories.site.BlogRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import com.baftanito.app.models.ServiceResponse
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