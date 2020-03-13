package com.aman.foodordering.ui.cart

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.aman.foodordering.R
import com.aman.foodordering.databinding.ActivityCartBinding
import com.aman.foodordering.extension.createFactory
import com.aman.foodordering.repo.OrderRepoI
import com.aman.foodordering.room.entity.Food
import com.aman.foodordering.ui.MainViewModel
import com.aman.foodordering.ui.adapter.FoodAdapter
import com.aman.foodordering.ui.adapter.OnClickListener
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_cart.*
import javax.inject.Inject

class CartActivity : DaggerAppCompatActivity() {

    private lateinit var viewModel: MainViewModel

    private lateinit var adapter: FoodAdapter

    private lateinit var binding: ActivityCartBinding

    private var cartList: List<Food> = listOf()

    @Inject
    lateinit var orderRepoI: OrderRepoI

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_cart)

        init()
        getCartList()
        setObserver()
        setRecyclerView()
        onClicks()

    }

    private fun init() {
        Log.d(TAG, " >>> Initializing viewModel")

        val factory = MainViewModel(orderRepoI).createFactory()
        viewModel = ViewModelProvider(this, factory).get(MainViewModel::class.java)
    }

    private fun getCartList() {
        viewModel.getCartList()
    }

    private fun setObserver() {
        viewModel.observableState.observe(this, Observer {
            binding.state = it
            if (it.success) {
                observeList()
            }
        })
    }

    private fun observeList() {
        viewModel.observableList.observe(this, Observer {
            adapter.result = it
            adapter.notifyDataSetChanged()
            calculateTotalPrice(it)
        })
    }

    private fun calculateTotalPrice(cartList: List<Food>?) {
        var totalPrice = 0
        cartList?.let { list ->
            list.forEach {
                if (it.quantity!! != 0) {
                    totalPrice += it.rate.toInt() * it.quantity!!
                }
            }
        }
        binding.totalPrice = String.format(getString(R.string.total_price), totalPrice.toString())
    }

    private fun setRecyclerView() {
        rv_cart.layoutManager = LinearLayoutManager(this)
        adapter = FoodAdapter(cartList, object : OnClickListener {
            override fun update(food: Food) {
                viewModel.updateItem(food)
            }
        })
        rv_cart.adapter = adapter
    }

    private fun onClicks() {
        view_place_order_bottom.setOnClickListener {  }
        btn_back.setOnClickListener { onBackPressed() }
    }

    companion object {
        const val TAG = "CartActivity"

        fun start(context: Context) {
            context.startActivity(Intent(context, CartActivity::class.java))
        }
    }
}
