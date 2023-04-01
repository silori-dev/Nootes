package com.androidregiment.nootes.modules

import com.androidregiment.nootes.data.dao.task.TaskDao
import com.androidregiment.nootes.data.database.NootesDatabase
import com.androidregiment.nootes.data.repo.task.TaskRepo
import com.androidregiment.nootes.data.repo.task.TaskRepoImpl
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
