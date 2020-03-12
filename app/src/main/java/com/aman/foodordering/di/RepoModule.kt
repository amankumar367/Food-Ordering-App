package com.aman.foodordering.di

import com.aman.foodordering.repo.OrderRepo
import com.aman.foodordering.repo.OrderRepoI
import com.aman.foodordering.room.database.AppDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepoModule {

    @Provides
    @Singleton
    fun provideOrderRepo(appDatabase: AppDatabase): OrderRepoI {
        return OrderRepo(appDatabase)
    }
}