package com.androidregiment.nootes.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "notes_table")
data class Note(
    @PrimaryKey(autoGenerate = true)
    val id : Int = 0,
    val title : String,
    val description : String,
    val dateAdded : String,
    val dateModified : String,
)
