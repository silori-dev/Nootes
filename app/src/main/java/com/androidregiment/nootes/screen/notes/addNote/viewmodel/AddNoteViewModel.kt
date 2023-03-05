package com.androidregiment.nootes.screen.notes.addNote.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.androidregiment.nootes.data.database.NooteDatabase
import com.androidregiment.nootes.data.entity.Note
import com.androidregiment.nootes.screen.notes.addNote.data.AddNoteRepoImpl
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class AddNoteViewModel(application: Application) : AndroidViewModel(application) {

    val repo: AddNoteRepoImpl

    private val _noteFlow: MutableStateFlow<Note> =
        MutableStateFlow(Note(title = "", description = ""))

    val noteFlow: StateFlow<Note> = _noteFlow

    init {
        val dao = NooteDatabase.getDatabase(application).notesDao()
        repo = AddNoteRepoImpl(dao)
    }

    fun onTitleChange(string: String) {
        _noteFlow.value = _noteFlow.value.copy(title = string)
    }


    fun onDescriptionChange(string: String) {
        _noteFlow.value = _noteFlow.value.copy(description = string)
    }

    fun onSaveNote() {
        viewModelScope.launch {
            repo.addNote(
                _noteFlow.value
            )
        }
    }

}