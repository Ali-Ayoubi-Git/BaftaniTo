package com.onlineShop.app.repositories.site

import com.onlineShop.app.api.site.SliderApi
import com.onlineShop.app.models.site.Slider
import dagger.hilt.android.scopes.ActivityScoped
import com.onlineShop.app.models.ServiceResponse
import javax.inject.Inject

@ActivityScoped
class SliderRepository @Inject constructor(private val api: SliderApi) {

    suspend fun getSliders(): ServiceResponse<Slider> {
        return try {
            api.getSlider()
        } catch (e: Exception) {
            ServiceResponse(status = "EXCEPTION", message = e.message)
        }
    }

    suspend fun getSliderById(id: Long): ServiceResponse<Slider> {
        return try {
            api.getSliderById(id)
        } catch (e: Exception) {
            ServiceResponse(status = "EXCEPTION", message = e.message)
        }
    }
}