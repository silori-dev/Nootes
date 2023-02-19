package com.androidregiment.nootes.data.dao

import androidx.room.*
import com.androidregiment.nootes.data.entity.Note
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addNote(note: Note)

    @Update
    suspend fun updateNote(note: Note)

    @Delete
    suspend fun deleteNote(note : Note)

    @Query("Select * FROM notes_table WHERE id = :id")
    fun getNoteById(id: String) :Flow< Note>

    @Query("SELECT * FROM notes_table")
    fun getAllNotes(): Flow<List<Note>>
}