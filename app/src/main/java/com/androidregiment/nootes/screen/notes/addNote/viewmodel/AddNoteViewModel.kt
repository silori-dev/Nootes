package com.androidregiment.nootes.screen.notes.addNote.viewmodel

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
class AddNoteViewModel @Inject constructor(
    private val noteRepository: NoteRepo,
) : ViewModel() {

    private val _noteFlow: MutableStateFlow<Note> =
        MutableStateFlow(Note(title = "", description = ""))

    val noteFlow: StateFlow<Note> = _noteFlow

    fun onTitleChange(string: String) {
        _noteFlow.value = _noteFlow.value.copy(title = string)
    }


    fun onDescriptionChange(string: String) {
        _noteFlow.value = _noteFlow.value.copy(description = string)
    }

    fun onSaveNote() {
        viewModelScope.launch {
            noteRepository.addNote(
                _noteFlow.value,
            )
        }
    }

}
