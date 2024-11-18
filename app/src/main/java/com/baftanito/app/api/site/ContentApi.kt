package com.baftanito.app.api.site

import com.baftanito.app.models.ServiceResponse
import com.baftanito.app.models.site.Content
import retrofit2.http.GET
import retrofit2.http.Path

interface ContentApi {

    @GET("/api/slider")
    suspend fun getContent(): ServiceResponse<Content>

    @GET("/api/slider/{title}")
    suspend fun getContentByTitle(@Path("title") id: String): ServiceResponse<Content>

}