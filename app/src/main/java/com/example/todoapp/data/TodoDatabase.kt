package com.example.todoapp.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Todo::class], version = 1)
abstract class TodoDatabase : RoomDatabase() {
    abstract fun todoDao() : TodoDao

    companion object {
        @Volatile private var INSTANCE: TodoDatabase? = null
        fun getDatabase (context: Context) : TodoDatabase =
            INSTANCE ?: synchronized(this) {
                Room.databaseBuilder(
                    context.applicationContext,
                    TodoDatabase::class.java,
                    "todo_db"
                ).build().also { INSTANCE = it }
            }
    }
}