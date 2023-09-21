package ru.anb.testunisafe.fiatures.list.data.model


import com.google.gson.annotations.SerializedName

data class AddItemResponse(
    @SerializedName("item_id")
    val itemId: Int,
    @SerializedName("success")
    val success: Boolean
)