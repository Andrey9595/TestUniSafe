package ru.anb.testunisafe.fiatures.shoppinglist.data.model


import com.google.gson.annotations.SerializedName

data class ShopListItem(
    @SerializedName("created")
    val created: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("is_crossed")
    val isCrossed: Boolean

)