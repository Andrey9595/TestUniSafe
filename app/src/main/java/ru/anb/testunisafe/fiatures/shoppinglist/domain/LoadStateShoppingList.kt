package ru.anb.testunisafe.fiatures.shoppinglist.domain

import androidx.annotation.StringRes
import ru.anb.testunisafe.core.domain.LoadState
import ru.anb.testunisafe.fiatures.list.data.model.AllShopListResponse
import ru.anb.testunisafe.fiatures.list.data.model.CreateShopListResponse
import ru.anb.testunisafe.fiatures.list.data.model.RemoveListResponse
import ru.anb.testunisafe.fiatures.shoppinglist.data.model.CrossOutResponse
import ru.anb.testunisafe.fiatures.shoppinglist.data.model.ShopListItem
import ru.anb.testunisafe.fiatures.shoppinglist.data.model.SingleShopListResponse

interface LoadStateShoppingList {
    open class Success<T>(open val data: T) : LoadStateShoppingList

    class Error(@StringRes val error: Int) : LoadStateShoppingList

    class Loading : LoadStateShoppingList

    class NotLoadedYet : LoadStateShoppingList

    class ToShoppingList(override val data: ShopListItem) : Success<ShopListItem>(data)

    class CrossItOff(override val data: CrossOutResponse) : Success<CrossOutResponse>(data)

    class GetShoppingList(override val data: SingleShopListResponse) : Success<SingleShopListResponse>(data)
}