package com.aman.foodordering.ui

import androidx.lifecycle.ViewModel
import com.aman.foodordering.repo.OrderRepoI
import com.aman.foodordering.room.entity.Food
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class MainViewModel(private val orderRepoI: OrderRepoI): ViewModel() {

    private val compositeDisposable = CompositeDisposable()

    fun addItem(food: Food) {
        compositeDisposable.add(
            orderRepoI.addForm(food)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({},{})
        )

    }

    fun removeItem(food: Food) {
        compositeDisposable.add(
            orderRepoI.removeForm(food)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({},{})
        )
    }

    fun getOrderList() {
        compositeDisposable.add(
            orderRepoI.getAllItem()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({},{})
        )
    }

}