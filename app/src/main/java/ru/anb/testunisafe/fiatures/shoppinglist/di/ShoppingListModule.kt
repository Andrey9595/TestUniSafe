package ru.anb.testunisafe.fiatures.shoppinglist.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import ru.anb.testunisafe.fiatures.list.data.ListApi
import ru.anb.testunisafe.fiatures.shoppinglist.data.ShoppingListApi
import ru.anb.testunisafe.fiatures.start.data.LoginApi
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class ShoppingListModule {

    @Provides
    @Singleton
    fun provideEventsApi(retrofit: Retrofit): ShoppingListApi {
        return retrofit.create(ShoppingListApi::class.java)
    }
}