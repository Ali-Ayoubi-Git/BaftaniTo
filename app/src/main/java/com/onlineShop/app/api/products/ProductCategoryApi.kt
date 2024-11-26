package com.onlineShop.app.api.products

import com.onlineShop.app.models.products.ProductCategory
import com.onlineShop.app.models.ServiceResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface ProductCategoryApi {

    @GET("/api/productCategory")
    suspend fun getCategory(): ServiceResponse<ProductCategory>

    @GET("/api/productCategory/{id}")
    suspend fun getCategoryById(@Path("id") id: Long): ServiceResponse<ProductCategory>
}