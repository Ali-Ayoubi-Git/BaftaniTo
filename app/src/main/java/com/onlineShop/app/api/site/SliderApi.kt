package com.onlineShop.app.api.site

import com.onlineShop.app.models.site.Slider
import com.onlineShop.app.models.ServiceResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface SliderApi {

    @GET("/api/slider")
    suspend fun getSlider(): ServiceResponse<Slider>

    @GET("/api/slider/{id}")
    suspend fun getSliderById(@Path("id") id: Long): ServiceResponse<Slider>

}