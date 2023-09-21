package ru.anb.testunisafe.fiatures.start.domain

import ru.anb.testunisafe.core.domain.LoadState

interface StartRepository {

   suspend fun signIn(): LoadState

   suspend fun isAuthorized(): Boolean
}