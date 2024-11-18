package com.baftanito.app.db.repository

import android.app.Application
import androidx.lifecycle.LiveData
import com.baftanito.app.db.BaftaniToDataBase
import com.baftanito.app.db.dao.UserEntityDao
import com.baftanito.app.db.models.UserEntity

class UserEntityRepository(application: Application) {

    private var userDao: UserEntityDao
    private lateinit var currentUserEntity: LiveData<UserEntity>

    init {
        val database = BaftaniToDataBase.getInstance(application)
        userDao = database.userDao()
        currentUserEntity = userDao.get()
    }

    fun getCurrentUser(): LiveData<UserEntity> {
        return currentUserEntity
    }

    suspend fun insert(user: UserEntity) {
        deleteAll()
        userDao.add(user)
    }

    suspend fun update(user: UserEntity) {
        userDao.update(user)
    }

    suspend fun delete(user: UserEntity) {
        userDao.delete(user)
    }

    suspend fun deleteAll() {
        return userDao.deleteAll()
    }

}