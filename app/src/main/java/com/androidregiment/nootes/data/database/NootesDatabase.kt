package com.androidregiment.nootes.data.database

import  android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.androidregiment.nootes.data.dao.NoteDao
import com.androidregiment.nootes.data.entity.Note

@Database(entities = [Note::class], version = 1, exportSchema = false)
abstract class NooteDatabase : RoomDatabase() {

    abstract fun notesDao(): NoteDao

    companion object {
        @Volatile
        private var Instance: NooteDatabase? = null

        fun getDatabase(context: Context): NooteDatabase {
            return Instance ?: synchronized(this) {
                Room.databaseBuilder(context, NooteDatabase::class.java, "noote_database")
                    .build()
                    .also { Instance = it }
            }
        }
    }
}