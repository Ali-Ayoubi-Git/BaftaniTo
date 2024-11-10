package com.baftanito.api.invoices

import com.baftanito.models.site.Slider
import net.holosen.onlineshopapp.models.ServiceResponse
import net.holosen.onlineshopapp.models.invoices.PaymentTransaction
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.POST

interface TransactionApi {
// dargah pardakht
    @POST("/api/trx/gotoPayment")
    suspend fun goToPayment(@Body dara: PaymentTransaction): ServiceResponse<String>



}