package com.baftanito.app.repositories.base

import java.util.*

open class BaseRepository {
    protected fun prepareToken(token: String): String {
        var fixedToken = token
        if (!fixedToken.lowercase(Locale.getDefault()).startsWith("bearer")) {
            fixedToken = "Bearer $token"
        }
        return fixedToken
    }

}