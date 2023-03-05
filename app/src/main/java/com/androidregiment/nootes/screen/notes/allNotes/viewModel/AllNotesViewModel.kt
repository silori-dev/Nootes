package com.androidregiment.nootes.screen.notes.allNotes.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.androidregiment.nootes.data.database.NooteDatabase
import com.androidregiment.nootes.data.entity.Note
import com.androidregiment.nootes.screen.notes.allNotes.data.AllNotesRepoImpl
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class AllNotesViewModel(application: Application) : AndroidViewModel(application) {

    val allNotes: Flow<List<Note>>

    private val repo: AllNotesRepoImpl

    init {
        val dao = NooteDatabase.getDatabase(application).notesDao()
        repo = AllNotesRepoImpl(dao)

        allNotes = repo.getAllNotes()
    }

    fun deleteNote(note: Note) {
        viewModelScope.launch {
            repo.deleteNote(note)
        }
    }
}