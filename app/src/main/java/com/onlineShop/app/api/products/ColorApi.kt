package com.onlineShop.app.api.products

import com.onlineShop.app.models.products.ProductColor
import com.onlineShop.app.models.ServiceResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface ColorApi {

    @GET("/api/color")
    suspend fun getColor(): ServiceResponse<ProductColor>

    @GET("/api/color/{id}")
    suspend fun getColorById(@Path("id") id: Long): ServiceResponse<ProductColor>

}