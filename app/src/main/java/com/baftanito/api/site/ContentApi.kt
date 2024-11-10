package com.baftanito.api.site

import com.baftanito.models.site.Content
import net.holosen.onlineshopapp.models.ServiceResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface ContentApi {

    @GET("/api/slider")
    suspend fun getContent(): ServiceResponse<Content>

    @GET("/api/slider/{title}")
    suspend fun getContentByTitle(@Path("title") id: String): ServiceResponse<Content>

}