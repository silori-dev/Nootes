package com.androidregiment.nootes.screen.notes.addNote.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.androidregiment.nootes.data.database.NooteDatabase
import com.androidregiment.nootes.screen.notes.editNote.data.EditNoteRepoImpl

class AddNoteViewModel(application: Application) : AndroidViewModel(application) {

    val repo : EditNoteRepoImpl

    init {
        val dao = NooteDatabase.getDatabase(application).notesDao()
        repo = EditNoteRepoImpl(dao)
    }

}