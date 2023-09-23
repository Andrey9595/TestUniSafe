package ru.anb.testunisafe.fiatures.shoppinglist.data.model


import com.google.gson.annotations.SerializedName

data class CrossOutResponse(
    @SerializedName("rows_affected")
    val rowsAffected: Int,
    @SerializedName("success")
    val success: Boolean
)