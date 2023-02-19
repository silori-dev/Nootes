package com.androidregiment.nootes.screen.notes.allNotes.data

import com.androidregiment.nootes.data.dao.NoteDao
import com.androidregiment.nootes.data.entity.Note
import com.androidregiment.nootes.data.repo.AllNotesRepo
import kotlinx.coroutines.flow.Flow

class AllNotesRepoImpl(private val noteDao: NoteDao) : AllNotesRepo {

    override fun getAllNotes(): Flow<List<Note>> = noteDao.getAllNotes()

    override suspend fun deleteNote(note: Note) = noteDao.deleteNote(note )

}