package com.pratamawijaya.day4.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import java.math.BigDecimal

@Parcelize
data class ItemModel(

    @field:SerializedName("item_type")
    val itemType: String? = null,

    @field:SerializedName("image_url")
    val imageUrl: String? = null,

    @field:SerializedName("name")
    val name: String? = null,

    @field:SerializedName("display_name")
    val displayName: String? = null,

    @field:SerializedName("update_priority")
    val updatePriority: String? = null,

    val score: Float? = 0f,

    val price: BigDecimal? = BigDecimal.ZERO,
    val volume: Float? = 0f
) : Parcelable