package com.baftanito.app.api.site

import com.baftanito.app.models.site.Slider
import com.baftanito.app.models.ServiceResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface SliderApi {

    @GET("/api/slider")
    suspend fun getSlider(): ServiceResponse<Slider>

    @GET("/api/slider/{id}")
    suspend fun getSliderById(@Path("id") id: Long): ServiceResponse<Slider>

}