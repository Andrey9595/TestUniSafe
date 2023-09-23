package ru.anb.testunisafe.fiatures.list.data.model


import com.google.gson.annotations.SerializedName

data class ShopList(
    @SerializedName("created")
    val created: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String
)