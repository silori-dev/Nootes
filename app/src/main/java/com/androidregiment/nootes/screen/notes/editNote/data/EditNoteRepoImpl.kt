package com.androidregiment.nootes.screen.notes.editNote.data

import com.androidregiment.nootes.data.dao.note.NoteDao
import com.androidregiment.nootes.data.entity.Note
import com.androidregiment.nootes.data.repo.note.EditNoteRepo
import kotlinx.coroutines.flow.Flow

class EditNoteRepoImpl(private val noteDao: NoteDao) : EditNoteRepo {
    override fun getNoteById(id: Int): Flow<Note> = noteDao.getNoteById(id)
    override suspend fun updateNote(note: Note) = noteDao.updateNote(note)
    override suspend fun deleteNote(note: Note) = noteDao.deleteNote(note)
}