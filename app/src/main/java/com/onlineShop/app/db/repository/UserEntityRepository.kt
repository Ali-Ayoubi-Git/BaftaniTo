package com.onlineShop.app.db.repository

import android.app.Application
import androidx.lifecycle.LiveData
import com.onlineShop.app.db.dao.UserEntityDao
import com.onlineShop.app.db.models.UserEntity
import com.onlineShop.app.db.OnlineShopDataBase

class UserEntityRepository(application: Application) {

    private var userDao: UserEntityDao
    private lateinit var currentUserEntity: LiveData<UserEntity>

    init {
        val database = OnlineShopDataBase.getInstance(application)
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