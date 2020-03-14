package com.aman.foodordering.ui.adapter

import com.aman.foodordering.room.entity.Food

interface OnClickListener {
    fun update(food: Food, position: Int)
}