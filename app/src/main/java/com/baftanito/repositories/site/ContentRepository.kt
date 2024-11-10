package com.baftanito.repositories.site

import com.baftanito.api.site.ContentApi
import com.baftanito.models.site.Content
import dagger.hilt.android.scopes.ActivityScoped
import net.holosen.onlineshopapp.models.ServiceResponse
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