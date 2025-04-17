package com.example.todoapp.data

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.IgnoredOnParcel
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "todo_table")
data class Todo(
    val title: String,
    val description: String?,
    val isDone: Boolean = false,
    @PrimaryKey(autoGenerate = true)
    @IgnoredOnParcel
    val id: Int = 0
) : Parcelable