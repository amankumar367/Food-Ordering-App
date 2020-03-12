package com.aman.foodordering.repo

import com.aman.foodordering.room.entity.Food
import io.reactivex.Single

interface OrderRepoI {
    fun addForm(food: Food): Single<String>

    fun removeForm(food: Food): Single<String>

    fun getAllItem(): Single<List<Food>>
}