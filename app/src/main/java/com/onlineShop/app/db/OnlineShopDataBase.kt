package com.onlineShop.app.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.onlineShop.app.db.dao.BasketEntityDao
import com.onlineShop.app.db.dao.UserEntityDao
import com.onlineShop.app.db.models.BasketEntity
import com.onlineShop.app.db.models.UserEntity

@Database(entities = [UserEntity::class, BasketEntity::class], version = 2)
abstract class OnlineShopDataBase : RoomDatabase() {

    abstract fun userDao(): UserEntityDao
    abstract fun basketDao(): BasketEntityDao

    companion object {
        private var instance: OnlineShopDataBase? = null
        fun getInstance(context: Context): OnlineShopDataBase {
            if (instance == null) {
                instance = Room.databaseBuilder(
                    context,
                    OnlineShopDataBase::class.java, "onlineshopdb.db"
                ).fallbackToDestructiveMigration().build()
            }
            return instance as OnlineShopDataBase
        }
    }
}