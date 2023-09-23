package ru.anb.testunisafe.fiatures.shoppinglist.data

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import ru.anb.testunisafe.core.domain.LoadState
import ru.anb.testunisafe.fiatures.list.data.model.CrossOutResponse
import ru.anb.testunisafe.fiatures.list.data.model.ShopListItemDto

interface ShoppingListApi {

    @GET("AddToShoppingList")
    suspend fun addToShoppingList(@Query("item_id") itemId: Int): Response<ShopListItemDto>

    @GET("CrossItOff")
    suspend fun crossItOff(@Query("item_id") itemId: Int): Response<CrossOutResponse>
}