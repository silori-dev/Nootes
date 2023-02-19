package com.androidregiment.nootes.screen.notes.allNotes.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.androidregiment.nootes.data.database.NooteDatabase
import com.androidregiment.nootes.data.entity.Note
import com.androidregiment.nootes.screen.notes.allNotes.data.AllNotesRepoImpl
import kotlinx.coroutines.flow.Flow

class AllNotesViewModel(application: Application) : AndroidViewModel(application) {

    val allNotes: Flow<List<Note>>

    private val repo: AllNotesRepoImpl

    init {
        val dao = NooteDatabase.getDatabase(application).notesDao()
        repo = AllNotesRepoImpl(dao)

        allNotes = repo.getAllNotes()

    }

}