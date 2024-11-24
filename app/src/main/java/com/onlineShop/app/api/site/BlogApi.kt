package com.onlineShop.app.api.site

import com.onlineShop.app.models.ServiceResponse
import com.onlineShop.app.models.site.Blog
import retrofit2.http.GET
import retrofit2.http.Path


interface BlogApi {

    @GET("/api/slider")
    suspend fun getBlog(): ServiceResponse<Blog>

    @GET("/api/slider/{id}")
    suspend fun getBlogById(@Path("id") id: Long): ServiceResponse<Blog>

}