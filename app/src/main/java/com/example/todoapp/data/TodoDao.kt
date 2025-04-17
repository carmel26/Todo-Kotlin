package com.example.todoapp.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.*

@Dao
class TodoDao {
    @Query("SELECT * FROM todo_table ORDER BY id DESC")
    fun getAllTodos(): LiveData<List<Todo>> {
        return TODO("Provide the return value")
    }

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(todo: Todo) {}

    @Update
    suspend fun update(todo: Todo) {}

    @Delete
    suspend fun delete(todo: Todo){}

}