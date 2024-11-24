package com.onlineShop.app.repositories.products

import com.baftanito.app.api.products.ProductCategoryApi
import com.onlineShop.app.models.products.ProductCategory
import dagger.hilt.android.scopes.ActivityScoped
import com.onlineShop.app.models.ServiceResponse
import javax.inject.Inject

@ActivityScoped
class ProductCategoryRepository @Inject constructor(private val api: ProductCategoryApi) {

    suspend fun getCategory(): ServiceResponse<ProductCategory> {
        return try {
            api.getCategory()
        } catch (e: Exception) {
            ServiceResponse(status = "EXCEPTION", message = e.message)
        }
    }

    suspend fun getProductsByCategoryId(id: Long): ServiceResponse<ProductCategory> {
        return try {
            api.getCategoryById(id)
        } catch (e: Exception) {
            ServiceResponse(status = "EXCEPTION", message = e.message)
        }
    }
}