package ru.anb.testunisafe.fiatures.list.data.model


import com.google.gson.annotations.SerializedName

data class AllShopListResponse(
    @SerializedName("shop_list")
    val shopList: List<ShopList>,
    @SerializedName("success")
    val success: Boolean
)