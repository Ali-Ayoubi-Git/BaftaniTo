package com.baftanito.repositories.invoices

import com.baftanito.api.invoices.TransactionApi
import dagger.hilt.android.scopes.ActivityScoped
import net.holosen.onlineshopapp.models.ServiceResponse
import net.holosen.onlineshopapp.models.invoices.PaymentTransaction
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