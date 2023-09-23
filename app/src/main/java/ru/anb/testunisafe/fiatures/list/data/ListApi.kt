package ru.anb.testunisafe.fiatures.list.data

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import ru.anb.testunisafe.fiatures.list.data.model.AllShopListResponse
import ru.anb.testunisafe.fiatures.list.data.model.CreateShopListResponse
import ru.anb.testunisafe.fiatures.list.data.model.RemoveListResponse

interface ListApi {

    @GET("GetAllMyShopLists")
    suspend fun getAllMyShopLists(@Query("key") key: String): Response<AllShopListResponse>

    @GET("CreateShoppingList")
    suspend fun createShoppingList(@Query("key") key: String, @Query("name") name: String): Response<CreateShopListResponse>

    @GET("RemoveShoppingList")
    suspend fun removeShoppingList(@Query("list_id") listId: Int): Response<RemoveListResponse>
}