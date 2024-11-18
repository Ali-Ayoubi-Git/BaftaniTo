package com.baftanito.app.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.baftanito.app.db.dao.BasketEntityDao
import com.baftanito.app.db.dao.UserEntityDao
import com.baftanito.app.db.models.BasketEntity
import com.baftanito.app.db.models.UserEntity

@Database(entities = [UserEntity::class, BasketEntity::class], version = 7)
abstract class BaftaniToDataBase : RoomDatabase() {

    abstract fun userDao(): UserEntityDao
    abstract fun basketDao(): BasketEntityDao

    companion object {
        private var instance: BaftaniToDataBase? = null
        fun getInstance(context: Context): BaftaniToDataBase {
            if (instance == null) {
                instance = Room.databaseBuilder(
                    context,
                    BaftaniToDataBase::class.java, "onlineshopdb.db"
                ).fallbackToDestructiveMigration().build()
            }
            return instance as BaftaniToDataBase
        }
    }
}