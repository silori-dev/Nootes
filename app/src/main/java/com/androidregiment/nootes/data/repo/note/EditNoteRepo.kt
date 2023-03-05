package com.androidregiment.nootes.data.repo.note

import com.androidregiment.nootes.data.entity.Note
import kotlinx.coroutines.flow.Flow

interface EditNoteRepo {

    fun getNoteById(id : Int) : Flow<Note>

    suspend fun updateNote(note: Note)

    suspend fun deleteNote(note: Note)

}