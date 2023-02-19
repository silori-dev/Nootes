package com.androidregiment.nootes.screen.notes.editNote.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.androidregiment.nootes.data.database.NooteDatabase
import com.androidregiment.nootes.data.entity.Note
import com.androidregiment.nootes.data.repo.AllNotesRepo
import com.androidregiment.nootes.data.repo.NoteRepo
import com.androidregiment.nootes.screen.notes.allNotes.data.AllNotesRepoImpl
import com.androidregiment.nootes.screen.notes.editNote.data.EditNoteRepoImpl
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class EditNoteViewModel(application: Application) : AndroidViewModel(application) {

    private val repo: EditNoteRepoImpl

    init {
        val dao = NooteDatabase.getDatabase(application).notesDao()
        repo = EditNoteRepoImpl(dao)

    }


}