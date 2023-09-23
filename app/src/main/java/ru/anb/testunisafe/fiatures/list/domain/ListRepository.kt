package ru.anb.testunisafe.fiatures.list.domain

import ru.anb.testunisafe.core.domain.LoadState

interface ListRepository {

    suspend fun getAllMyShopLists(): LoadState

    suspend fun createShoppingList(name: String): LoadState

    suspend fun removeShoppingList(id: Int): LoadState
}