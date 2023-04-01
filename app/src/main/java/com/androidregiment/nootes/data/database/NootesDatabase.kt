package com.androidregiment.nootes.data.database

import  android.content.Context
import androidx.room.*
import com.androidregiment.nootes.data.dao.NoteDao
import com.androidregiment.nootes.data.dao.TaskDao
import com.androidregiment.nootes.data.entity.Note
import com.androidregiment.nootes.data.entity.Task
import com.androidregiment.nootes.data.converter.PriorityConverter

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
        private const val DATABASE_NAME = "noote_database"

        @Volatile
        private var instance: NootesDatabase? = null

        fun getDatabase(context: Context): NootesDatabase {
            return instance ?: synchronized(this) {
                Room.databaseBuilder(context, NootesDatabase::class.java, DATABASE_NAME)
                    .build()
                    .also { instance = it }
            }
        }
    }
}
