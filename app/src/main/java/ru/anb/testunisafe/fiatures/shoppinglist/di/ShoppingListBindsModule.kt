package ru.anb.testunisafe.fiatures.shoppinglist.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.anb.testunisafe.fiatures.list.data.ListRepositoryImpl
import ru.anb.testunisafe.fiatures.list.domain.ListRepository
import ru.anb.testunisafe.fiatures.shoppinglist.data.ShoppingListRepositoryImpl
import ru.anb.testunisafe.fiatures.shoppinglist.domain.ShoppingListRepository
import ru.anb.testunisafe.fiatures.start.data.StartRepositoryImpl
import ru.anb.testunisafe.fiatures.start.domain.StartRepository

@InstallIn(SingletonComponent::class)
@Module
abstract class ShoppingListBindsModule {
    @Binds
    abstract fun bindsShoppingListRepository(ShoppingListRepositoryImpl: ShoppingListRepositoryImpl): ShoppingListRepository
}