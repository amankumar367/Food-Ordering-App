package com.aman.foodordering.ui.cart

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import com.aman.foodordering.R
import com.aman.foodordering.extension.createFactory
import com.aman.foodordering.repo.OrderRepoI
import com.aman.foodordering.ui.MainViewModel
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class CartActivity : DaggerAppCompatActivity() {

    private lateinit var viewModel: MainViewModel

    @Inject
    lateinit var orderRepoI: OrderRepoI

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart)

        init()
        setObserver()
        onClicks()

    }

    private fun init() {
        Log.d(TAG, " >>> Initializing viewModel")

        val factory = MainViewModel(orderRepoI).createFactory()
        viewModel = ViewModelProvider(this, factory).get(MainViewModel::class.java)
    }

    private fun setObserver() {

    }

    private fun onClicks() {

    }

    companion object {
        const val TAG = "CartActivity"

        fun start(context: Context) {
            context.startActivity(Intent(context, CartActivity::class.java))
        }
    }
}
