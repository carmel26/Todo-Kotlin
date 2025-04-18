package com.example.todoapp.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.todoapp.data.Todo
import com.example.todoapp.data.TodoDatabase
import com.example.todoapp.data.TodoRepository
import kotlinx.coroutines.launch

class TodoViewModel(app: Application) : AndroidViewModel(app) {
    private val repo: TodoRepository
    val allTodos: LiveData<List<Todo>>

    init {
        val dao = TodoDatabase.getDatabase(app).todoDao()
        repo = TodoRepository(dao)
        allTodos = repo.allTodos
    }

    fun insert(todo: Todo) = viewModelScope.launch { repo.insert(todo) }
    fun update(todo: Todo) = viewModelScope.launch { repo.update(todo) }
    fun delete(todo: Todo) = viewModelScope.launch { repo.delete(todo) }
}