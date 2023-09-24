package ru.anb.testunisafe.fiatures.shoppinglist.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import ru.anb.testunisafe.fiatures.shoppinglist.domain.LoadStateShoppingList
import ru.anb.testunisafe.fiatures.shoppinglist.domain.ShoppingListRepository
import javax.inject.Inject

@HiltViewModel
class ShoppingListViewModel @Inject constructor(
    private val shoppingListRepository: ShoppingListRepository
) : ViewModel() {

    private val _shoppingListState =
        MutableStateFlow<LoadStateShoppingList>(LoadStateShoppingList.NotLoadedYet())
    val shoppingListState get() = _shoppingListState.asStateFlow()

    fun addToShoppingList(id: Int, name: String, count: String) {
        viewModelScope.launch {
            val result = shoppingListRepository.addToShoppingList(id, name, count)
            _shoppingListState.value = result
        }
    }

    fun crossItOff(listId: Int, itemId: Int) {
        viewModelScope.launch {
            val result = shoppingListRepository.crossItOff(listId, itemId)
            _shoppingListState.value = result
        }
    }

    fun getShoppingList(listId: Int) {
        viewModelScope.launch {
            val result = shoppingListRepository.getShoppingList(listId)
            _shoppingListState.value = result
        }
    }

    fun removeFromList(listId: Int, itemId: Int) {
        viewModelScope.launch {
            val result = shoppingListRepository.removeFromList(listId, itemId)
            _shoppingListState.value = result
        }
    }
}