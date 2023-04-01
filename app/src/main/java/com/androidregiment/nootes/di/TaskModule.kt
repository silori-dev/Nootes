package com.androidregiment.nootes.di

import com.androidregiment.nootes.data.dao.TaskDao
import com.androidregiment.nootes.data.database.NootesDatabase
import com.androidregiment.nootes.data.repository.TaskRepo
import com.androidregiment.nootes.data.repository.impl.TaskRepoImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface TaskModule {

    @Singleton
    @Binds
    fun bindTaskRepository(repository : TaskRepoImpl) : TaskRepo

    companion object {

        @Singleton
        @Provides
        fun provideTaskDao(database : NootesDatabase) : TaskDao =
            database.taskDao

    }

}
