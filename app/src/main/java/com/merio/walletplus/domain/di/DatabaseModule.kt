package com.merio.walletplus.domain.di

import android.content.Context
import androidx.room.Room
import com.merio.walletplus.domain.database.Database
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun providesDatabase(
        @ApplicationContext context: Context
    ): Database = Room.databaseBuilder(context, Database::class.java, "database").build()
}