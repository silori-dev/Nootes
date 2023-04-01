package com.androidregiment.nootes.screen.notes.editNote.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import com.androidregiment.nootes.data.database.NootesDatabase
import com.androidregiment.nootes.data.entity.Note
import com.androidregiment.nootes.screen.notes.editNote.data.EditNoteRepoImpl
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class EditNoteViewModel(
    application: Application,
    savedStateHandle: SavedStateHandle
) : AndroidViewModel(application) {

    private val repo: EditNoteRepoImpl

    private val noteId = savedStateHandle.get<Int>("noteId")

    private val _noteFlow: MutableStateFlow<Note> =
        MutableStateFlow(Note(title = "", description = ""))

    val noteFlow: StateFlow<Note> = _noteFlow

    init {
        val dao = NootesDatabase.getDatabase(application).notesDao()
        repo = EditNoteRepoImpl(dao)

        if (noteId != null) {
            getNote(noteId)
        }
    }

    private fun getNote(id: Int) {
        viewModelScope.launch {

            repo.getNoteById(id).collect { note ->
                _noteFlow.value = note
            }
        }
    }

    fun onTitleChange(string: String) {
        _noteFlow.value = _noteFlow.value.copy(title = string)
    }

    fun onDescriptionChange(string: String) {
        _noteFlow.value = _noteFlow.value.copy(description = string)

    }

    fun updateNote() {
        viewModelScope.launch {
            repo.updateNote(
                _noteFlow.value
            )
        }
    }
}