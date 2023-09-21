package ru.anb.testunisafe.core.domain

import androidx.annotation.StringRes

interface LoadState {

    open class Success<T>(open val data: T) : LoadState

    class Error(@StringRes val error: Int) : LoadState

    class Loading : LoadState

    class NotLoadedYet : LoadState

    class UserIsExist<T>(override val data: T) : Success<T>(data)

    class UserIsMotExist<T>(override val data: T) : Success<T>(data)

}