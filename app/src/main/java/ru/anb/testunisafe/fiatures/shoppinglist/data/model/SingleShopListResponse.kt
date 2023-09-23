package ru.anb.testunisafe.fiatures.shoppinglist.data.model


import com.google.gson.annotations.SerializedName

data class SingleShopListResponse(
    @SerializedName("item_list")
    val itemList: List<ShopListItem>,
    @SerializedName("success")
    val success: Boolean
)