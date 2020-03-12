package com.aman.foodordering.ui

import android.os.Bundle
import com.aman.foodordering.R
import com.aman.foodordering.repo.OrderRepoI
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var orderRepoI: OrderRepoI

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }
}
