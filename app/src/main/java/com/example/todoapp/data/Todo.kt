package com.example.todoapp.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "todo_table")
data class Todo(val title: String, val description: String?, val isDone: Boolean = false) {
    @PrimaryKey(autoGenerate = true) val id: Int = 0
}