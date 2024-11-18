package com.baftanito.app.api.products

import com.baftanito.app.models.products.ProductCategory
import com.baftanito.app.models.ServiceResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface ProductCategoryApi {

    @GET("/api/ProductCategory")
    suspend fun getCategory(): ServiceResponse<ProductCategory>

    @GET("/api/ProductCategory/{id}")
    suspend fun getCategoryById(@Path("id") id: Long): ServiceResponse<ProductCategory>

}