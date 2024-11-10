package com.baftanito.api.site

import com.baftanito.models.site.Blog
import net.holosen.onlineshopapp.models.ServiceResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface BlogApi {

    @GET("/api/slider")
    suspend fun getBlog(): ServiceResponse<Blog>

    @GET("/api/slider/{id}")
    suspend fun getBlogById(@Path("id") id: Long): ServiceResponse<Blog>

}