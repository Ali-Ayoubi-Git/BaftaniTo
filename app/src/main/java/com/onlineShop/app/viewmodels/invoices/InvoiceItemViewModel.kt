package com.onlineShop.app.viewmodels.invoices

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.onlineShop.app.models.invoices.Invoice
import com.onlineShop.app.repositories.invoices.InvoiceRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import com.onlineShop.app.models.ServiceResponse
import com.onlineShop.app.utils.ThisApp
import javax.inject.Inject

@HiltViewModel
class InvoiceItemViewModel @Inject constructor(
    private val repository: InvoiceRepository
) : ViewModel() {

    var token: String = ThisApp.token
    var invoiceId: Long = ThisApp.invoiceId

    var data = mutableStateOf<Invoice?>(null)
    var isLoading = mutableStateOf(true)

    init {
        getInvoiceById(invoiceId) { response ->
            isLoading.value = false
            if (response.status == "OK") {
                data.value = response.data!![0]
            }
        }
    }

    fun getInvoiceById(
        id: Long,
        onResponse: (response: ServiceResponse<Invoice>) -> Unit
    ) {
        viewModelScope.launch {
            var response = repository.getInvoiceById(id, token)
            onResponse(response)
        }
    }

}