package net.holosen.onlineshopapp.api.customer

import com.baftanito.models.customers.User
import net.holosen.onlineshopapp.models.ServiceResponse
import net.holosen.onlineshopapp.models.customer.UserVM
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