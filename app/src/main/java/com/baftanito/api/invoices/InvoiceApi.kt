package com.baftanito.api.invoices

import com.baftanito.models.invoices.Invoice
import net.holosen.onlineshopapp.models.ServiceResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface InvoiceApi {

    @GET("/api/invoice")
    suspend fun getInvoice(): ServiceResponse<Invoice>

    @GET("/api/invoice/{id}")
    suspend fun getInvoiceById(@Path("id") id: Long): ServiceResponse<Invoice>

}