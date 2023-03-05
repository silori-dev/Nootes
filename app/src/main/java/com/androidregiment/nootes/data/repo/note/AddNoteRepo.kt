package com.androidregiment.nootes.data.repo.note

import com.androidregiment.nootes.data.entity.Note

interface AddNoteRepo {
    suspend fun addNote(note: Note)
}