package com.baftanito.models.invoices

import com.baftanito.models.products.Product

data class InvoiceItem(
    var id: Long?,
    var product: Product?,
    var quantity: Int?,
    var unitPrice: Long?,


    )
