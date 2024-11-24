package com.onlineShop.app.models.invoices

import com.onlineShop.app.models.products.Product

data class InvoiceItem(
    var id: Long?,
    var product: Product?,
    var quantity: Int?,
    var unitPrice: Long?,


    )
