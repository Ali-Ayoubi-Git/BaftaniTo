package com.baftanito.repositories.invoices

import com.baftanito.api.invoices.InvoiceApi
import com.baftanito.models.invoices.Invoice
import dagger.hilt.android.scopes.ActivityScoped
import net.holosen.onlineshopapp.models.ServiceResponse
import com.baftanito.repositories.base.BaseRepository
import javax.inject.Inject

@ActivityScoped
class InvoiceRepository @Inject constructor(private val api: InvoiceApi) : BaseRepository() {

    suspend fun getInvoiceById(
        id: Long,
        token: String
    ): ServiceResponse<Invoice> {
        return try {
            api.getInvoiceById(id, prepareToken(token))
        } catch (e: Exception) {
            ServiceResponse(status = "EXCEPTION", message = e.message)
        }
    }

    suspend fun getInvoiceByUserId(
        userId: Long,
        pageIndex: Int,
        pageSize: Int,
        token: String
    ): ServiceResponse<Invoice> {
        return try {
            api.getInvoiceByUserId(userId, pageIndex, pageSize, prepareToken(token))
        } catch (e: Exception) {
            ServiceResponse(status = "EXCEPTION", message = e.message)
        }
    }

    suspend fun addInvoice(
        data: Invoice,
        token: String
    ): ServiceResponse<Invoice> {
        return try {
            api.addInvoice(data, prepareToken(token))
        } catch (e: Exception) {
            ServiceResponse(status = "EXCEPTION", message = e.message)
        }
    }
}