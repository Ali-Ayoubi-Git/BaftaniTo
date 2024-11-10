package com.baftanito.viewmodels.site

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.baftanito.models.site.Content
import com.baftanito.repositories.site.ContentRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import net.holosen.onlineshopapp.models.ServiceResponse
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