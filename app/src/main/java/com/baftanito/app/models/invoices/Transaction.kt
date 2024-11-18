package com.baftanito.app.models.invoices

data class Transaction (
    var amount: Int?,
    var cardholder: String?,
    var code: Int?,
    var custom: String?,
    var customerPhone: String?,
    var id: Long,
    var orderId: Int,
    var refId: Int,
    var refundRequest: String?,
    var shaparakRefId: String,
    var transId: String?,
)