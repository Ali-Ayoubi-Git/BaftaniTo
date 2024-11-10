package com.baftanito.models.customers

data class User(
    var id: Long,
    var customer: Costomer?,
    val password: String?,
    val username: String?
)
