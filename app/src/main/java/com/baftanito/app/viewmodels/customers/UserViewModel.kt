package com.baftanito.app.viewmodels.customers

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.baftanito.app.models.customers.User
import com.baftanito.app.repositories.customer.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import com.baftanito.app.models.ServiceResponse
import com.baftanito.app.models.customers.UserVM
import net.holosen.onlineshopapp.utils.ThisApp
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(
    private val repository: UserRepository
) : ViewModel() {

    var token: String = ThisApp.token

    fun getUserInfo(onResponse: (response: ServiceResponse<User>) -> Unit) {
        viewModelScope.launch {
            var response = repository.getUserInfo(token)
            onResponse(response)
        }
    }

    fun changePassword(data: UserVM, onResponse: (response: ServiceResponse<User>) -> Unit) {
        viewModelScope.launch {
            var response = repository.changePassword(data, token)
            onResponse(response)
        }
    }

    fun login(data: UserVM, onResponse: (response: ServiceResponse<UserVM>) -> Unit) {
        viewModelScope.launch {
            var response = repository.login(data)
            onResponse(response)
        }
    }

    fun register(data: UserVM, onResponse: (response: ServiceResponse<User>) -> Unit) {
        viewModelScope.launch {
            var response = repository.register(data)
            onResponse(response)
        }
    }

    fun update(data: UserVM, onResponse: (response: ServiceResponse<User>) -> Unit) {
        viewModelScope.launch {
            var response = repository.update(data, token)
            onResponse(response)
        }
    }
}