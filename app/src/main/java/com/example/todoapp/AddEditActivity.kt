package com.example.todoapp

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.todoapp.data.Todo
import com.example.todoapp.databinding.ActivityAddEditBinding

class AddEditActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAddEditBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddEditBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSave.setOnClickListener {
            val title = binding.etTitle.text.toString().trim()
            if (title.isEmpty()) {
                binding.etTitle.error = "Required"
                return@setOnClickListener
            }
            val description = binding.etDescription.text.toString().trim().takeIf { it.isNotEmpty() }
            val todo = Todo(title = title, description = description)
            val intent = Intent().apply { putExtra("todo", todo) }
            setResult(Activity.RESULT_OK, intent)
            finish()
        }
    }
}