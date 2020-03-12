package com.aman.foodordering.room.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.aman.foodordering.room.entity.Food

@Dao
interface FoodDao {

    @Insert
    fun addFood(food: Food)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(foods: List<Food>)

    @Update
    fun updateFood(food: Food)

    @Query("SELECT * FROM FOOD")
    fun getAllList(): LiveData<List<Food>>

    @Delete
    fun deleteFood(food: Food)

}