package com.baftanito.app.models.invoices

import com.baftanito.app.models.customers.UserVM

data class PaymentTransaction(
    var items: List<InvoiceItem>,
    var user: UserVM
)