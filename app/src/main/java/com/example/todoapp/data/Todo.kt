package com.example.todoapp.data

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "todo_table")
data class Todo(val title: String, val description: String?, val isDone: Boolean = false) : Parcelable {
    @PrimaryKey(autoGenerate = true) val id: Int = 0
}