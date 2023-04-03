package com.androidregiment.nootes.data.database

import androidx.room.*
import com.androidregiment.nootes.data.converter.PriorityConverter
import com.androidregiment.nootes.data.dao.NoteDao
import com.androidregiment.nootes.data.dao.TaskDao
import com.androidregiment.nootes.data.entity.Note
import com.androidregiment.nootes.data.entity.Task

@Database(entities = [Note::class, Task::class],
    version = NootesDatabase.DATABASE_VERSION,
    autoMigrations = [
        AutoMigration(from = 2, to = 3),
    ],
    exportSchema = true)
@TypeConverters(PriorityConverter::class)
abstract class NootesDatabase : RoomDatabase() {

    abstract val noteDao: NoteDao
    abstract val taskDao: TaskDao

    companion object {
        const val DATABASE_VERSION = 3
         const val DATABASE_NAME = "noote_database"
    }
}
