package ru.anb.testunisafe.fiatures.shoppinglist.domain

import retrofit2.http.GET
import retrofit2.http.Query
import ru.anb.testunisafe.core.domain.LoadState

interface ShoppingListRepository {


    suspend fun addToShoppingList(id: Int): LoadState

    suspend fun crossItOff(id: Int): LoadState
}