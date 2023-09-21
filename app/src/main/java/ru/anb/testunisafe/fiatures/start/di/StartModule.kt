package ru.anb.testunisafe.fiatures.start.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import ru.anb.testunisafe.fiatures.start.data.LoginApi
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class StartModule {

    @Provides
    @Singleton
    fun provideEventsApi(retrofit: Retrofit): LoginApi {
        return retrofit.create(LoginApi::class.java)
    }
}