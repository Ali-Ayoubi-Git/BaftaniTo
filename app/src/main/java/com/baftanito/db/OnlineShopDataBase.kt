package net.holosen.onlineshopapp.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import net.holosen.onlineshopapp.db.dao.BasketEntityDao
import net.holosen.onlineshopapp.db.dao.UserEntityDao
import net.holosen.onlineshopapp.db.models.BasketEntity
import net.holosen.onlineshopapp.db.models.UserEntity

@Database(entities = [UserEntity::class, BasketEntity::class], version = 7)
abstract class OnlineShopDataBase : RoomDatabase() {

    abstract fun userDao(): UserEntityDao
    abstract fun basketDao(): BasketEntityDao

    companion object {
        private var instance: OnlineShopDataBase? = null
        fun getInstance(context: Context): OnlineShopDataBase {
            if (instance == null) {
                instance = Room.databaseBuilder(
                    context,
                    OnlineShopDataBase::class.java, "onlineshop.db"
                ).fallbackToDestructiveMigration().build()
            }
            return instance as OnlineShopDataBase
        }
    }
}