package ru.anb.testunisafe.fiatures.shoppinglist.data

import ru.anb.testunisafe.core.domain.LoadState
import ru.anb.testunisafe.fiatures.shoppinglist.domain.ShoppingListRepository
import javax.inject.Inject

class ShoppingListRepositoryImpl @Inject constructor(
    private val shoppingListApi: ShoppingListApi
) : ShoppingListRepository {

    override suspend fun addToShoppingList(id: Int): LoadState {
        TODO("Not yet implemented")
    }

    override suspend fun crossItOff(id: Int): LoadState {
        TODO("Not yet implemented")
    }
}