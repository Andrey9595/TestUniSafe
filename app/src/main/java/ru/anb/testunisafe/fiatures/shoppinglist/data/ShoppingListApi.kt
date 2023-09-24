package ru.anb.testunisafe.fiatures.shoppinglist.data

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import ru.anb.testunisafe.fiatures.shoppinglist.data.model.CrossOutResponse
import ru.anb.testunisafe.fiatures.shoppinglist.data.model.ItemRemoveResponse
import ru.anb.testunisafe.fiatures.shoppinglist.data.model.ShopListItem
import ru.anb.testunisafe.fiatures.shoppinglist.data.model.SingleShopListResponse

interface ShoppingListApi {

    @GET("AddToShoppingList")
    suspend fun addToShoppingList(
        @Query("id") id: Int,
        @Query("value") name: String,
        @Query("n") count: String
    ): Response<ShopListItem>

    @GET("CrossItOff")
    suspend fun crossItOff(
        @Query("list_id") listId: Int,
        @Query("id") itemId: Int
    ): Response<CrossOutResponse>

    @GET("GetShoppingList")
    suspend fun getShoppingList(@Query("list_id") listId: Int): Response<SingleShopListResponse>

    @GET("RemoveFromList")

    suspend fun removeFromList(
        @Query("list_id") listId: Int,
        @Query("item_id") itemId: Int
    ) : Response<ItemRemoveResponse>
}