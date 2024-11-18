package com.baftanito.app.repositories.products

import com.baftanito.app.api.products.ColorApi
import com.baftanito.app.models.products.ProductColor
import dagger.hilt.android.scopes.ActivityScoped
import com.baftanito.app.models.ServiceResponse
import javax.inject.Inject

@ActivityScoped
class ColorRepository @Inject constructor(private val api: ColorApi) {

    suspend fun getColors(): ServiceResponse<ProductColor> {
        return try {
            api.getColor()
        } catch (e: Exception) {
            ServiceResponse(status = "EXCEPTION", message = e.message)
        }
    }

    suspend fun getColorById(id: Long): ServiceResponse<ProductColor> {
        return try {
            api.getColorById(id)
        } catch (e: Exception) {
            ServiceResponse(status = "EXCEPTION", message = e.message)
        }
    }
}