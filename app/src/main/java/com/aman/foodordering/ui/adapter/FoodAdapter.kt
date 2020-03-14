package com.aman.foodordering.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.aman.foodordering.R
import com.aman.foodordering.databinding.FoodDataBinding
import com.aman.foodordering.room.entity.Food
import kotlinx.android.synthetic.main.layout_single_item.view.*

class FoodAdapter(var result: List<Food>,
                  private val listener: OnClickListener)
    : RecyclerView.Adapter<FoodAdapter.FoodViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodViewHolder {
        return FoodViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.layout_single_item, parent, false),
            listener
        )
    }

    override fun getItemCount(): Int {
        return result.size
    }

    override fun onBindViewHolder(holder: FoodViewHolder, position: Int) {
        holder.bind(result[position], position)
        holder.setIsRecyclable(false)
    }

    inner class FoodViewHolder(private val foodDataBinding: FoodDataBinding,
                               private val listener: OnClickListener)
        : RecyclerView.ViewHolder(foodDataBinding.root) {

        fun bind(food: Food, position: Int) {
            foodDataBinding.food = food
            if (food.quantity == 0) {
                foodDataBinding.shouldShowAddButton = true
                foodDataBinding.shouldPlusMinusButton = false
            } else {
                foodDataBinding.shouldShowAddButton = false
                foodDataBinding.shouldPlusMinusButton = true
            }
            onClick(food, position)
        }

        private fun onClick(food: Food, position: Int) {
            foodDataBinding.root.tv_plus.setOnClickListener {
                if (food.quantity == 20) return@setOnClickListener
                food.quantity = food.quantity!!.inc()
                listener.update(food, position)
            }
            foodDataBinding.root.tv_minus.setOnClickListener {
                food.quantity = food.quantity!!.dec()
                listener.update(food, position)
            }
            foodDataBinding.root.btn_add.setOnClickListener {
                food.quantity = food.quantity!!.inc()
                listener.update(food, position)
            }
        }
    }
}