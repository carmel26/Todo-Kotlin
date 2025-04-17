package com.example.todoapp.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.todoapp.data.Todo
import com.example.todoapp.databinding.TodoItemBinding

class TodoAdapter(private val onCheck: (Todo) -> Unit,
    private  val onLongPress: (Todo) -> Unit
): RecyclerView.Adapter<TodoAdapter.TodoViewHolder>() {

    private var todos = listOf<Todo>()


    inner class TodoViewHolder(val binding : TodoItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind (todo: Todo){
            binding.tvTitle.text = todo.title
            binding.tvDescription.text = todo.description
            binding.cbDone.isChecked = todo.isDone
            binding.cbDone.setOnCheckedChangeListener {
                _, _ ->onCheck(todo.copy(isDone = !todo.isDone))
            }
            binding.root.setOnLongClickListener {
                onLongPress(todo); true
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ) = TodoViewHolder (
        TodoItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )

    override fun onBindViewHolder(
        holder: TodoViewHolder,
        position: Int
    ) {
        return holder.bind(todos[position])
    }

    override fun getItemCount() = todos.size

    fun submitList(list: List<Todo>) {
        todos = list
        notifyDataSetChanged()
    }


}