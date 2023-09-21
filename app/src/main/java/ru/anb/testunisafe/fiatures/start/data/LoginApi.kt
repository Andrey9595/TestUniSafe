package ru.anb.testunisafe.fiatures.start.data

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import ru.anb.testunisafe.fiatures.start.data.model.AuthResult

interface LoginApi {

    @GET("CreateTestKey")
    suspend fun createCay(): Response<String>

    @GET("Authentication")
    suspend fun auth(@Query("key") key: String): Response<AuthResult>
}