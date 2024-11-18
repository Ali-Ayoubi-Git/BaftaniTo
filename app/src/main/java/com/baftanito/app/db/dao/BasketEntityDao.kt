package com.baftanito.app.db.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.baftanito.app.db.models.BasketEntity

@Dao
interface BasketEntityDao {

    @Insert
    fun add(basketEntity: BasketEntity)

    @Update
    fun update(basketEntity: BasketEntity)

    @Delete
    fun delete(basketEntity: BasketEntity)

    @Query("select * from BasketEntity")
    fun getAll(): List<BasketEntity>

    @Query("delete from BasketEntity")
    fun deleteAll()

    @Query("select * from BasketEntity")
    fun getAllLive(): LiveData<List<BasketEntity>>
}