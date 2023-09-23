package ru.anb.testunisafe.fiatures.start.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.anb.testunisafe.core.data.PersistentStore
import ru.anb.testunisafe.core.data.PersistentStoreImpl
import ru.anb.testunisafe.fiatures.start.data.StartRepositoryImpl
import ru.anb.testunisafe.fiatures.start.domain.StartRepository

@InstallIn(SingletonComponent::class)
@Module
abstract class StartBindsModule {

    @Binds
    abstract fun bindsStartRepository(startRepositoryImpl: StartRepositoryImpl): StartRepository

    @Binds
    abstract fun bindPersistentStore(persistentStore: PersistentStoreImpl): PersistentStore
}