package com.baftanito.models.invoices

import com.baftanito.models.customers.User


data class Invoice(
    var id: Long?,
    var addDate: String,
    var items : List<InvoiceItem>?,
    var paymentDate: String?,
    var status: String?,
    var transaction: List<Transaction>,
    var  user:User?

)