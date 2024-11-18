package com.baftanito.app.models.invoices

import com.baftanito.app.models.products.Product

data class InvoiceItem(
    var id: Long?,
    var product: Product?,
    var quantity: Int?,
    var unitPrice: Long?,


    )
