package ru.anb.testunisafe.fiatures.start.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import ru.anb.testunisafe.core.domain.LoadState
import ru.anb.testunisafe.fiatures.start.data.StartRepositoryImpl
import ru.anb.testunisafe.fiatures.start.domain.StartRepository
import javax.inject.Inject

@HiltViewModel
class StartViewModel @Inject constructor(private val startRepository: StartRepository) :
    ViewModel() {

    private val _startState = MutableStateFlow<LoadState>(LoadState.NotLoadedYet())
    val startState get() = _startState.asStateFlow()

    init {
        checkToken()
    }

    fun auth() {
        viewModelScope.launch {
            val result = startRepository.signIn()
            _startState.value = result
        }
    }

   private fun checkToken() {
       viewModelScope.launch {
           if (startRepository.isAuthorized())
               _startState.value = LoadState.Success(true)
       }
   }
}