package ru.anb.testunisafe.fiatures.list.data

import ru.anb.testunisafe.R
import ru.anb.testunisafe.core.data.PersistentStore
import ru.anb.testunisafe.core.domain.LoadState
import ru.anb.testunisafe.fiatures.list.domain.ListRepository
import javax.inject.Inject

class ListRepositoryImpl @Inject constructor(
    private val listApi: ListApi,
    private val persistentStore: PersistentStore
) : ListRepository {
    override suspend fun getAllMyShopLists(): LoadState {
        val token = persistentStore.getToken() ?: return LoadState.Error(R.string.not_authorized)
        val result = listApi.getAllMyShopLists(token)
        return if (result.isSuccessful && result.body() != null) {
            LoadState.AllLists(result.body()!!)
        } else LoadState.Error(R.string.eror)
    }

    override suspend fun createShoppingList(name: String): LoadState {
        val token = persistentStore.getToken() ?: return LoadState.Error(R.string.not_authorized)
        val result = listApi.createShoppingList(token, name)
        return if (result.isSuccessful && result.body() != null) {
            LoadState.ListCreated(result.body()!!)
        } else LoadState.Error(R.string.eror)
    }

    override suspend fun removeShoppingList(id: Int): LoadState {
        val result = listApi.removeShoppingList(id)
        return if (result.isSuccessful && result.body() != null) {
            LoadState.DeleteList(result.body()!!)
        } else LoadState.Error(R.string.eror)
    }
}