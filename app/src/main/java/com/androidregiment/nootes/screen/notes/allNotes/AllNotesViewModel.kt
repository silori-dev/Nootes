package com.androidregiment.nootes.screen.notes.allNotes

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.androidregiment.nootes.data.entity.Note
import com.androidregiment.nootes.data.repository.NoteRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AllNotesViewModel @Inject constructor(
    private val noteRepository: NoteRepo,
) : ViewModel() {

    val allNotes: Flow<List<Note>> = noteRepository.getAllNotes()

    fun deleteNote(note: Note) {
        viewModelScope.launch {
            noteRepository.deleteNote(note)
        }
    }
}
