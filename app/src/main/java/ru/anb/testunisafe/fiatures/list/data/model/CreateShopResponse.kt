package ru.anb.testunisafe.fiatures.list.data.model


import com.google.gson.annotations.SerializedName

data class CreateShopResponse(
    @SerializedName("list_id")
    val listId: Int,
    @SerializedName("success")
    val success: Boolean
)