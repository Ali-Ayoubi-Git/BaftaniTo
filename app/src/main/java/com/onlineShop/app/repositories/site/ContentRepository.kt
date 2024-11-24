package com.onlineShop.app.repositories.site

import com.onlineShop.app.api.site.ContentApi
import dagger.hilt.android.scopes.ActivityScoped
import com.onlineShop.app.models.ServiceResponse
import com.onlineShop.app.models.site.Content
import javax.inject.Inject

@ActivityScoped
class ContentRepository @Inject constructor(private val api: ContentApi) {

    suspend fun getContent(): ServiceResponse<Content> {
        return try {
            api.getContent()
        } catch (e: Exception) {
            ServiceResponse(status = "EXCEPTION", message = e.message)
        }
    }

    suspend fun getContentByTitle(title: String): ServiceResponse<Content> {
        return try {
            api.getContentByTitle(title)
        } catch (e: Exception) {
            ServiceResponse(status = "EXCEPTION", message = e.message)
        }
    }
}