package com.onlineShop.app.models.invoices

import com.onlineShop.app.models.customers.UserVM

data class PaymentTransaction(
    var items: List<InvoiceItem>,
    var user: UserVM
)