package ru.anb.testunisafe.fiatures.list.data.model


import com.google.gson.annotations.SerializedName

data class CreateShopListResponse(
    @SerializedName("list_id")
    val listId: Int,
    @SerializedName("success")
    val success: Boolean
)