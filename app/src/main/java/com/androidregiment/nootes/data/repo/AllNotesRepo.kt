package com.androidregiment.nootes.data.repo

import com.androidregiment.nootes.data.entity.Note
import kotlinx.coroutines.flow.Flow

interface AllNotesRepo {

    fun getAllNotes(): Flow<List<Note>>

    suspend fun deleteNote(note: Note)

}