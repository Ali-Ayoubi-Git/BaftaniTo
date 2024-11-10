package com.baftanito.repositories.site

import com.baftanito.api.site.BlogApi
import com.baftanito.models.site.Blog
import dagger.hilt.android.scopes.ActivityScoped
import net.holosen.onlineshopapp.models.ServiceResponse
import javax.inject.Inject

@ActivityScoped
class BlogRepository @Inject constructor(private val api: BlogApi) {

    suspend fun getBlog(): ServiceResponse<Blog> {
        return try {
            api.getBlog()
        } catch (e: Exception) {
            ServiceResponse(status = "EXCEPTION", message = e.message)
        }
    }

    suspend fun getBlogById(id: Long): ServiceResponse<Blog> {
        return try {
            api.getBlogById(id)
        } catch (e: Exception) {
            ServiceResponse(status = "EXCEPTION", message = e.message)
        }
    }
}