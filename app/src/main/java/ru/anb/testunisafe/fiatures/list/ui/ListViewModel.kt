package ru.anb.testunisafe.fiatures.list.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import ru.anb.testunisafe.core.domain.LoadState
import ru.anb.testunisafe.fiatures.list.domain.ListRepository
import javax.inject.Inject

@HiltViewModel
class ListViewModel @Inject constructor(private val listRepository: ListRepository) : ViewModel() {

    private val _listState = MutableStateFlow<LoadState>(LoadState.NotLoadedYet())
    val listState get() = _listState.asStateFlow()

    fun getAllMyShopLists() {
        viewModelScope.launch {
            val result = listRepository.getAllMyShopLists()
            _listState.value = result
        }
    }

    fun createShoppingList() {
        viewModelScope.launch {
            val result = listRepository.createShoppingList()
            _listState.value = result
        }
    }

    fun removeShoppingList(id: Int) {
        viewModelScope.launch {
            val result = listRepository.removeShoppingList(id)
            _listState.value = result
        }
    }
}