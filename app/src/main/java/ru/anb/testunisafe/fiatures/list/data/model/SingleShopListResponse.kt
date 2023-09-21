package ru.anb.testunisafe.fiatures.list.data.model


import com.google.gson.annotations.SerializedName

data class SingleShopListResponse(
    @SerializedName("item_list")
    val itemList: List<ShopListItemDto>,
    @SerializedName("success")
    val success: Boolean
)