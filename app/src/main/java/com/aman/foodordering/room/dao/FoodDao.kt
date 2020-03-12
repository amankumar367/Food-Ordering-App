package com.aman.foodordering.room.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.aman.foodordering.room.entity.Food

@Dao
interface FoodDao {

    @Insert
    fun addForm(food: Food)

    @Update
    fun updateForm(food: Food)

    @Query("SELECT * FROM FORM")
    fun getAllList(): List<Food>

    @Delete
    fun deleteForm(food: Food)

}