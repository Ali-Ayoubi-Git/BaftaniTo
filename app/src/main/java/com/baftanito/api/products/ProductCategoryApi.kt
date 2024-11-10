package com.baftanito.api.products

import com.baftanito.models.products.ProductCategory
import com.baftanito.models.products.ProductColor
import net.holosen.onlineshopapp.models.ServiceResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface ProductCategoryApi {

    @GET("/api/ProductCategory")
    suspend fun getCategory(): ServiceResponse<ProductCategory>

    @GET("/api/ProductCategory/{id}")
    suspend fun getCategoryById(@Path("id") id: Long): ServiceResponse<ProductCategory>

}