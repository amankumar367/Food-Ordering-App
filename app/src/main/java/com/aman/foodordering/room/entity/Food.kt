package com.aman.foodordering.room.entity

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.IgnoredOnParcel
import kotlinx.android.parcel.Parcelize

@Entity(tableName = "form")
@Parcelize
data class Food(
    @ColumnInfo(name = "title")
    @SerializedName("title")
    var title: String,

    @ColumnInfo(name = "description")
    @SerializedName("description")
    var description: String,

    @ColumnInfo(name = "budget")
    @SerializedName("budget")
    var budget: Long,

    @ColumnInfo(name = "currency")
    @SerializedName("currency")
    var currency: String,

    @ColumnInfo(name = "rate")
    @SerializedName("rate")
    var rate: String,

    @ColumnInfo(name = "payment_mode")
    @SerializedName("payment_mode")
    var paymentMode: String,

    @ColumnInfo(name = "start_date")
    @SerializedName("start_date")
    var startDate: Long,

    @ColumnInfo(name = "job_term")
    @SerializedName("job_term")
    var jobTerm: String
): Parcelable {
    @IgnoredOnParcel
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Int = 0

    constructor():this(
        title ="", description = "", budget = 0L, currency = "",
        rate = "", paymentMode = "", startDate = 0L, jobTerm = ""
    )

}