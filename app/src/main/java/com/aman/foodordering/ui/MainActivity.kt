package com.aman.foodordering.ui

import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import com.aman.foodordering.R
import com.aman.foodordering.extension.createFactory
import com.aman.foodordering.repo.OrderRepoI
import com.aman.foodordering.room.entity.Food
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity() {

    private lateinit var viewModel: MainViewModel
    @Inject
    lateinit var orderRepoI: OrderRepoI

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()
        insetData()
        getAllList()
    }

    private fun getAllList() {
        viewModel.getOrderList()
    }

    private fun insetData() {
        viewModel.addItem(Food("title", "bsdkjf", "$", "10", 1))
    }

    private fun init() {
        Log.d(TAG, " >>> Initializing viewModel")

        val factory = MainViewModel(orderRepoI).createFactory()
        viewModel = ViewModelProvider(this, factory).get(MainViewModel::class.java)
    }

    companion object {
        const val TAG = "MainActivity"
    }
}
