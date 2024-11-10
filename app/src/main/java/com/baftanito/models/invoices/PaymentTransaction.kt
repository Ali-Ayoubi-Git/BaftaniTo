package net.holosen.onlineshopapp.models.invoices

import com.baftanito.models.invoices.InvoiceItem
import net.holosen.onlineshopapp.models.customer.UserVM

data class PaymentTransaction(
    var items: List<InvoiceItem>,
    var user: UserVM
)