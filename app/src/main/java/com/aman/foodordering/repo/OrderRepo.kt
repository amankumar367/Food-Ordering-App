package com.aman.foodordering.repo

import com.aman.foodordering.room.database.AppDatabase
import com.aman.foodordering.room.entity.Food
import io.reactivex.Single
import java.lang.Exception

class OrderRepo(private val db: AppDatabase): OrderRepoI {
    override fun addForm(food: Food): Single<String> {
        return Single.create { emitter ->
            try {
                db.foodDao().addFood(food)
                emitter.onSuccess("Insert food item Success")
            } catch (e: Exception) {
                emitter.onError(e)
            }
        }
    }

    override fun removeForm(food: Food): Single<String> {
        return Single.create { emitter ->
            try {
                db.foodDao().deleteFood(food)
                emitter.onSuccess("Removing food item Success")
            } catch (e: Exception) {
                emitter.onError(e)
            }
        }
    }

    override fun getAllItem(): Single<List<Food>> {
        return Single.create { emitter ->
            try {
                db.foodDao().getAllList().let {
                    if (it.value?.isNotEmpty()!!) {
                        emitter.onSuccess(it.value!!)
                    } else {
                        emitter.onError(Exception("List is empty"))
                    }
                }
            } catch (e: Exception) {
                emitter.onError(e)
            }
        }
    }
}