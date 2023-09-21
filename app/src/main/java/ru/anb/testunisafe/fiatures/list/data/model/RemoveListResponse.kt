package ru.anb.testunisafe.fiatures.list.data.model


import com.google.gson.annotations.SerializedName

data class RemoveListResponse(
    @SerializedName("new_value")
    val newValue: Boolean,
    @SerializedName("success")
    val success: Boolean
)