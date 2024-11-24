package com.onlineShop.app.api.customers

import com.onlineShop.app.models.customers.User
import com.onlineShop.app.models.ServiceResponse
import com.onlineShop.app.models.customers.UserVM
import retrofit2.http.*

interface UserApi {

    @GET("/api/user")
    suspend fun getUserInfo(@Header("Authorization") token: String): ServiceResponse<User>

    @PUT("/api/user/changePassword")
    suspend fun changePassword(
        @Body user: UserVM,
        @Header("Authorization") token: String
    ): ServiceResponse<User>

    @POST("/api/user/login")
    suspend fun login(
        @Body user: UserVM
    ): ServiceResponse<UserVM>


    @POST("/api/user/register")
    suspend fun register(
        @Body user: UserVM
    ): ServiceResponse<User>

    @PUT("/api/user/update")
    suspend fun update(
        @Body user: UserVM,
        @Header("Authorization") token: String
    ): ServiceResponse<User>

}