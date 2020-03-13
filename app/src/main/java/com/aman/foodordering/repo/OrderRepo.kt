package com.aman.foodordering.repo

import androidx.lifecycle.LiveData
import com.aman.foodordering.room.database.AppDatabase
import com.aman.foodordering.room.entity.Food
import io.reactivex.Single

class OrderRepo(private val db: AppDatabase): OrderRepoI {

    override fun update(food: Food): Single<String> {
        return Single.create { emitter ->
            try {
                db.foodDao().updateFood(food)
                emitter.onSuccess("Update food item Success")
            } catch (e: Exception) {
                emitter.onError(e)
            }
        }
    }

    override fun getAllItem(): Single<LiveData<List<Food>>> {
        return Single.create { emitter ->
            try {
                emitter.onSuccess(db.foodDao().getAllList())
            } catch (e: Exception) {
                emitter.onError(e)
            }
        }
    }
}