package ru.anb.testunisafe.core.data

interface PersistentStore {

   suspend fun saveToken(token: String)

    suspend fun isAuthorized(): Boolean

    suspend fun getToken(): String?
}