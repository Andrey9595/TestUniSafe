package ru.anb.testunisafe.fiatures.shoppinglist.ui

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import ru.anb.testunisafe.fiatures.shoppinglist.domain.ShoppingListRepository
import javax.inject.Inject

@HiltViewModel
class ShoppingListViewModel @Inject constructor(
    private val shoppingListRepository: ShoppingListRepository) : ViewModel() {
}