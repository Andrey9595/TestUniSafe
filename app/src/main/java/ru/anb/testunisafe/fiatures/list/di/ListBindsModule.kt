package ru.anb.testunisafe.fiatures.list.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.anb.testunisafe.fiatures.list.data.ListRepositoryImpl
import ru.anb.testunisafe.fiatures.list.domain.ListRepository
import ru.anb.testunisafe.fiatures.start.data.StartRepositoryImpl
import ru.anb.testunisafe.fiatures.start.domain.StartRepository

@InstallIn(SingletonComponent::class)
@Module
abstract class ListBindsModule {
    @Binds
    abstract fun bindsListRepository(listRepositoryImpl: ListRepositoryImpl): ListRepository
}