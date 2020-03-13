package com.aman.foodordering.ui

import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import com.aman.foodordering.R
import com.aman.foodordering.extension.createFactory
import com.aman.foodordering.repo.OrderRepoI
import com.aman.foodordering.room.entity.Food
import com.aman.foodordering.ui.cart.CartFragment
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
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
        onClick()
    }

    private fun init() {
        Log.d(TAG, " >>> Initializing viewModel")

        val factory = MainViewModel(orderRepoI).createFactory()
        viewModel = ViewModelProvider(this, factory).get(MainViewModel::class.java)
    }

    private fun insetData() {
        viewModel.addItem(Food("title", "bsdkjf", "$", "10", 1))
    }

    private fun getAllList() {
        viewModel.getOrderList()
    }

    private fun onClick() {
        view_bottom.setOnClickListener {
            openNewFormScreen()
        }
    }

    private fun openNewFormScreen() {
        Log.d(TAG, " >>> Opening New From Screen")
        val instance = CartFragment.newInstance()
        supportFragmentManager.beginTransaction()
            .replace(R.id.mainActivity, instance, null)
            .commit()
    }

    companion object {
        const val TAG = "MainActivity"
    }
}
