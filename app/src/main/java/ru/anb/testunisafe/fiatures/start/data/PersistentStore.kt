package ru.anb.testunisafe.fiatures.start.data

interface PersistentStore {

   suspend fun saveToken(token: String)

    suspend fun isAuthorized(): Boolean
}