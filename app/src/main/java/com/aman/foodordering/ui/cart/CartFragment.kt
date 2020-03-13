package com.aman.foodordering.ui.cart

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.aman.foodordering.R
import com.aman.foodordering.extension.createFactory
import com.aman.foodordering.repo.OrderRepoI
import com.aman.foodordering.ui.MainViewModel
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class CartFragment: DaggerFragment() {

    private lateinit var viewModel: MainViewModel

    @Inject
    lateinit var orderRepoI: OrderRepoI

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_cart, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        init()
        setObserver()
        onClicks()

    }

    private fun setObserver() {

    }

    private fun onClicks() {

    }

    private fun init() {
        Log.d(TAG, " >>> Initializing viewModel")

        val factory = MainViewModel(orderRepoI).createFactory()
        viewModel = ViewModelProvider(this, factory).get(MainViewModel::class.java)
    }

    companion object {
        const val TAG = "CartFragment"
        fun newInstance(): CartFragment = CartFragment()
    }
}