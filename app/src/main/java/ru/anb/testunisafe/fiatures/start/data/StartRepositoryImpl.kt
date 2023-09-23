package ru.anb.testunisafe.fiatures.start.data

import ru.anb.testunisafe.R
import ru.anb.testunisafe.core.data.PersistentStore
import ru.anb.testunisafe.core.domain.LoadState
import ru.anb.testunisafe.fiatures.start.domain.StartRepository
import javax.inject.Inject

class StartRepositoryImpl @Inject constructor(
    private val loginApi: LoginApi,
    private val persistentStore: PersistentStore
) : StartRepository {

    override suspend fun signIn(): LoadState {
        val result = loginApi.createCay()
        return if (result.isSuccessful && result.body() != null) {
            result.body()?.let { persistentStore.saveToken(it) }
            val newResult = loginApi.auth(result.body()!!)
            if (newResult.body()?.success == true)
                LoadState.Success(Unit)
            else LoadState.Error(R.string.eror)
        } else LoadState.Error(R.string.eror)
    }

    override  suspend fun isAuthorized(): Boolean {
       return persistentStore.isAuthorized()
    }
}