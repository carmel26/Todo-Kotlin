package com.example.todoapp.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.todoapp.data.Todo
import com.example.todoapp.databinding.TodoItemBinding

import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter

class TodoAdapter(
    private val onCheck: (Todo) -> Unit,
    private val onLongPress: (Todo) -> Unit
) : ListAdapter<Todo, TodoAdapter.TodoViewHolder>(DIFF_CALLBACK) {

    inner class TodoViewHolder(val binding: TodoItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(todo: Todo) {
            binding.tvTitle.text = todo.title
            binding.tvDescription.text = todo.description

            binding.cbDone.setOnCheckedChangeListener(null)
            binding.cbDone.isChecked = todo.isDone
            binding.cbDone.setOnCheckedChangeListener { _, _ ->
                onCheck(todo.copy(isDone = !todo.isDone))
            }

            binding.root.setOnLongClickListener {
                onLongPress(todo)
                true
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        val binding = TodoItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TodoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    companion object {
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Todo>() {
            override fun areItemsTheSame(oldItem: Todo, newItem: Todo): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Todo, newItem: Todo): Boolean {
                return oldItem == newItem
            }
        }
    }
}
