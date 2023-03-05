package com.androidregiment.nootes.data.database

import  android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.androidregiment.nootes.data.dao.note.NoteDao
import com.androidregiment.nootes.data.dao.task.TaskDao
import com.androidregiment.nootes.data.entity.Note
import com.androidregiment.nootes.data.entity.Task
import com.androidregiment.nootes.data.utils.PriorityConverter

@Database(entities = [Note::class, Task::class], version = 2, exportSchema = false)
@TypeConverters(PriorityConverter::class)
abstract class NooteDatabase : RoomDatabase() {

    abstract fun notesDao(): NoteDao
    abstract fun taskDao(): TaskDao

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