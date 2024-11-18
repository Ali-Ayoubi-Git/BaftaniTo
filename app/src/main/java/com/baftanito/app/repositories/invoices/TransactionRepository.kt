package com.baftanito.app.repositories.invoices

import com.baftanito.app.api.invoices.TransactionApi
import dagger.hilt.android.scopes.ActivityScoped
import com.baftanito.app.models.ServiceResponse
import com.baftanito.app.models.invoices.PaymentTransaction
import javax.inject.Inject

@ActivityScoped
class TransactionRepository @Inject constructor(private val api: TransactionApi) {

    suspend fun goToPayment(
        data: PaymentTransaction
    ): ServiceResponse<String> {
        return try {
            api.goToPayment(data)
        } catch (e: Exception) {
            ServiceResponse(status = "EXCEPTION", message = e.message)
        }
    }
}