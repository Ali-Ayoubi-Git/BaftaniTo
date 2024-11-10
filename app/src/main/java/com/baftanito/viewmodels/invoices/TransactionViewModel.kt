package com.baftanito.viewmodels.invoices

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.baftanito.repositories.invoices.TransactionRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import net.holosen.onlineshopapp.models.ServiceResponse
import net.holosen.onlineshopapp.models.invoices.PaymentTransaction
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