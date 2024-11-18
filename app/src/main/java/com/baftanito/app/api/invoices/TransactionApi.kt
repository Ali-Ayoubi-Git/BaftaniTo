package com.baftanito.app.api.invoices

import com.baftanito.app.models.ServiceResponse
import com.baftanito.app.models.invoices.PaymentTransaction
import retrofit2.http.Body
import retrofit2.http.POST

interface TransactionApi {
// dargah pardakht
    @POST("/api/trx/gotoPayment")
    suspend fun goToPayment(@Body dara: PaymentTransaction): ServiceResponse<String>



}