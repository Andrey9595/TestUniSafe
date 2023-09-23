package ru.anb.testunisafe.fiatures.shoppinglist.data

import ru.anb.testunisafe.R
import ru.anb.testunisafe.fiatures.shoppinglist.domain.LoadStateShoppingList
import ru.anb.testunisafe.fiatures.shoppinglist.domain.ShoppingListRepository
import javax.inject.Inject

class ShoppingListRepositoryImpl @Inject constructor(
    private val shoppingListApi: ShoppingListApi
) : ShoppingListRepository {

    override suspend fun addToShoppingList(
        id: Int,
        name: String,
        count: Int
    ): LoadStateShoppingList {
        val result = shoppingListApi.addToShoppingList(id, name, count)
        return if (result.isSuccessful && result.body() != null)
            LoadStateShoppingList.ToShoppingList(result.body()!!)
        else LoadStateShoppingList.Error(R.string.eror)
    }

    override suspend fun crossItOff(listId: Int, itemId: Int): LoadStateShoppingList {
        val result = shoppingListApi.crossItOff(listId, itemId)
        return if (result.isSuccessful && result.body() != null)
            LoadStateShoppingList.CrossItOff(result.body()!!)
        else LoadStateShoppingList.Error(R.string.eror)
    }

    override suspend fun getShoppingList(listId: Int): LoadStateShoppingList {
        val result = shoppingListApi.getShoppingList(listId)
        return if (result.isSuccessful && result.body() != null)
            LoadStateShoppingList.GetShoppingList(result.body()!!)
        else LoadStateShoppingList.Error(R.string.eror)
    }
}