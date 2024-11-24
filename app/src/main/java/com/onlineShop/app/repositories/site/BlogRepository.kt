package com.onlineShop.app.repositories.site

import com.onlineShop.app.api.site.BlogApi
import com.onlineShop.app.models.site.Blog
import dagger.hilt.android.scopes.ActivityScoped
import com.onlineShop.app.models.ServiceResponse
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