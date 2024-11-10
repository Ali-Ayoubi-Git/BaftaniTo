package com.baftanito.repositories.site

import com.baftanito.api.site.SliderApi
import com.baftanito.models.site.Slider
import dagger.hilt.android.scopes.ActivityScoped
import net.holosen.onlineshopapp.models.ServiceResponse
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