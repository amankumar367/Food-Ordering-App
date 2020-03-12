package com.aman.foodordering.repo

import com.aman.foodordering.room.database.AppDatabase
import com.aman.foodordering.room.entity.Food
import io.reactivex.Single

class OrderRepo(private val db: AppDatabase): OrderRepoI {
    override fun addForm(food: Food): Single<String> {
        return Single.create {  }
    }

    override fun removeForm(food: Food): Single<String> {
        return Single.create {  }
    }

    override fun getAllItem(): Single<List<Food>> {
        return Single.create {  }
    }
}