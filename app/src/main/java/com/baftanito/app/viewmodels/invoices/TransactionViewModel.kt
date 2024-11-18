package com.baftanito.app.viewmodels.invoices

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import com.baftanito.app.models.ServiceResponse
import com.baftanito.app.models.invoices.PaymentTransaction
import javax.inject.Inject

@HiltViewModel
class TransactionViewModel @Inject constructor(
    private val repository: com.baftanito.app.repositories.invoices.TransactionRepository
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