package com.baftanito.app.repositories.site

import dagger.hilt.android.scopes.ActivityScoped
import com.baftanito.app.models.ServiceResponse
import com.baftanito.app.models.site.Content
import javax.inject.Inject

@ActivityScoped
class ContentRepository @Inject constructor(private val api: com.baftanito.app.api.site.ContentApi) {

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