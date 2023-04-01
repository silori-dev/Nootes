package com.androidregiment.nootes.screen.notes.editNote.viewModel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.androidregiment.nootes.data.entity.Note
import com.androidregiment.nootes.data.repo.note.NoteRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class EditNoteViewModel @Inject constructor(
    private val repo: NoteRepo,
    savedStateHandle: SavedStateHandle,
) : ViewModel() {

    private val noteId = savedStateHandle.get<Int>("noteId")

    private val _noteFlow: MutableStateFlow<Note> =
        MutableStateFlow(Note(title = "", description = ""))

    val noteFlow: StateFlow<Note> = _noteFlow

    init {
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
            repo.updateNote(_noteFlow.value)
        }
    }
}
