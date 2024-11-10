package com.baftanito.api.products

import com.baftanito.models.products.ProductColor
import net.holosen.onlineshopapp.models.ServiceResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface ColorApi {

    @GET("/api/color")
    suspend fun getColor(): ServiceResponse<ProductColor>

    @GET("/api/color/{id}")
    suspend fun getColorById(@Path("id") id: Long): ServiceResponse<ProductColor>

}