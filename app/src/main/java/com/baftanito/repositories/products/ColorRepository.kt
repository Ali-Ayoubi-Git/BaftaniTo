package com.baftanito.repositories.products

import com.baftanito.api.products.ColorApi
import com.baftanito.models.products.ProductColor
import dagger.hilt.android.scopes.ActivityScoped
import net.holosen.onlineshopapp.models.ServiceResponse
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