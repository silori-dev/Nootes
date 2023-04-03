package com.androidregiment.nootes.di

import com.androidregiment.nootes.data.dao.NoteDao
import com.androidregiment.nootes.data.database.NootesDatabase
import com.androidregiment.nootes.data.repository.NoteRepo
import com.androidregiment.nootes.data.repository.impl.NoteRepoImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface NoteModule {

    @Singleton
    @Binds
    fun bindNoteRepository(repository: NoteRepoImpl): NoteRepo


    companion object {
        @Singleton
        @Provides
        fun provideNoteDao(database: NootesDatabase): NoteDao =
            database.noteDao
    }

}
