package com.androidregiment.nootes.modules

import com.androidregiment.nootes.data.dao.note.NoteDao
import com.androidregiment.nootes.data.database.NootesDatabase
import com.androidregiment.nootes.data.repo.note.NoteRepo
import com.androidregiment.nootes.data.repo.note.NoteRepoImpl
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
