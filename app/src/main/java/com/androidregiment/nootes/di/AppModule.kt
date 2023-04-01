package com.androidregiment.nootes.di

import android.content.Context
import androidx.room.Room
import com.androidregiment.nootes.data.database.NootesDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext appContext: Context): NootesDatabase =
        Room
            .databaseBuilder(appContext, NootesDatabase::class.java, "noote_database")
            .build()

}
