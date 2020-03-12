package com.aman.foodordering.room.entity

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.IgnoredOnParcel
import kotlinx.android.parcel.Parcelize

@Entity(tableName = "food")
@Parcelize
data class Food(
    @ColumnInfo(name = "title")
    @SerializedName("title")
    var title: String,

    @ColumnInfo(name = "description")
    @SerializedName("description")
    var description: String,

    @ColumnInfo(name = "currency")
    @SerializedName("currency")
    var currency: String,

    @ColumnInfo(name = "rate")
    @SerializedName("rate")
    var rate: String,

    @ColumnInfo(name = "quantity")
    @SerializedName("quantity")
    var quantity: Int?
): Parcelable {
    @IgnoredOnParcel
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Int = 0

    constructor(): this(title ="", description = "", currency = "", rate = "", quantity = 0)

}