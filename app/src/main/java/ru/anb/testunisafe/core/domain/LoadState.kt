package ru.anb.testunisafe.core.domain

import androidx.annotation.StringRes
import ru.anb.testunisafe.fiatures.list.data.model.AllShopListResponse
import ru.anb.testunisafe.fiatures.list.data.model.CreateShopListResponse
import ru.anb.testunisafe.fiatures.list.data.model.RemoveListResponse

interface LoadState {

    open class Success<T>(open val data: T) : LoadState

    class Error(@StringRes val error: Int) : LoadState

    class Loading : LoadState

    class NotLoadedYet : LoadState

    class ListCreated(override val data: CreateShopListResponse) : Success<CreateShopListResponse>(data)

    class AllLists(override val data: AllShopListResponse) : Success<AllShopListResponse>(data)

    class DeleteList(override val data: RemoveListResponse) : Success<RemoveListResponse>(data)

}