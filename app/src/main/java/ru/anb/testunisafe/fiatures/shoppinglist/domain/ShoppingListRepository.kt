package ru.anb.testunisafe.fiatures.shoppinglist.domain

interface ShoppingListRepository {

    suspend fun addToShoppingList(id: Int, name: String, count: String): LoadStateShoppingList

    suspend fun crossItOff(listId: Int, itemId: Int): LoadStateShoppingList

    suspend fun getShoppingList(ListId: Int): LoadStateShoppingList

    suspend fun removeFromList(listId: Int, itemId: Int): LoadStateShoppingList
}