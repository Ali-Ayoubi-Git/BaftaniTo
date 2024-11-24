package com.onlineShop.app.viewmodels.invoices

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import com.onlineShop.app.models.ServiceResponse
import com.onlineShop.app.models.invoices.PaymentTransaction
import com.onlineShop.app.repositories.invoices.TransactionRepository
import javax.inject.Inject

@HiltViewModel
class TransactionViewModel @Inject constructor(
    private val repository: TransactionRepository
) : ViewModel() {

    fun goToPayment(
        data: PaymentTransaction,
        onResponse: (response: ServiceResponse<String>) -> Unit
    ) {
        viewModelScope.launch {
            var response = repository.goToPayment(data)
            onResponse(response)
        }
    }
}