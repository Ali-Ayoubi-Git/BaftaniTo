package com.baftanito.app.repositories.customer

import com.baftanito.app.models.customers.User
import dagger.hilt.android.scopes.ActivityScoped
import com.baftanito.app.api.customers.UserApi
import com.baftanito.app.models.ServiceResponse
import com.baftanito.app.models.customers.UserVM
import com.baftanito.app.repositories.base.BaseRepository
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