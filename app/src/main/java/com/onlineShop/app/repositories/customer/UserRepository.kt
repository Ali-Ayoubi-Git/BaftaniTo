package com.onlineShop.app.repositories.customer

import com.onlineShop.app.models.customers.User
import dagger.hilt.android.scopes.ActivityScoped
import com.onlineShop.app.api.customers.UserApi
import com.onlineShop.app.models.ServiceResponse
import com.onlineShop.app.models.customers.UserVM
import com.onlineShop.app.repositories.base.BaseRepository
import javax.inject.Inject

@ActivityScoped
class UserRepository @Inject constructor(private val api: UserApi) : BaseRepository() {

    suspend fun getUserInfo(
        token: String
    ): ServiceResponse<User> {
        return try {
            api.getUserInfo(prepareToken(token))
        } catch (e: Exception) {
            ServiceResponse(status = "EXCEPTION", message = e.message)
        }
    }

    suspend fun changePassword(
        data: UserVM,
        token: String
    ): ServiceResponse<User> {
        return try {
            api.changePassword(data, prepareToken(token))
        } catch (e: Exception) {
            ServiceResponse(status = "EXCEPTION", message = e.message)
        }
    }

    suspend fun login(
        data: UserVM
    ): ServiceResponse<UserVM> {
        return try {
            api.login(data)
        } catch (e: Exception) {
            ServiceResponse(status = "EXCEPTION", message = e.message)
        }
    }

    suspend fun register(
        data: UserVM
    ): ServiceResponse<User> {
        return try {
            api.register(data)
        } catch (e: Exception) {
            ServiceResponse(status = "EXCEPTION", message = e.message)
        }
    }

    suspend fun update(
        data: UserVM,
        token: String
    ): ServiceResponse<User> {
        return try {
            api.update(data, prepareToken(token))
        } catch (e: Exception) {
            ServiceResponse(status = "EXCEPTION", message = e.message)
        }
    }
}