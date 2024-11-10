package net.holosen.onlineshopapp.db.repository

import android.app.Application
import androidx.lifecycle.LiveData
import net.holosen.onlineshopapp.db.OnlineShopDataBase
import net.holosen.onlineshopapp.db.dao.UserEntityDao
import net.holosen.onlineshopapp.db.models.UserEntity

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