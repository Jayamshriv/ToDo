package com.example.todo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MainActivity : AppCompatActivity() {



    private val todoList : MutableList<Model> = TODO()


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rvTodo = findViewById<RecyclerView>(R.id.rvTodo)
        val addBtnn = findViewById<Button>(R.id.addBtn)
        val etTask= findViewById<EditText>(R.id.etTask)

        todoList.add(Model("dfghjkl",false))
        todoList.add(Model("dfghjkl",false))
        todoList.add(Model("dfghjkl",false))
        todoList.add(Model("dfghjkl",false))
        todoList.add(Model("dfghjkl",false))
        todoList.add(Model("dfghjkl",false))

        rvTodo.layoutManager = LinearLayoutManager(this)
        val toDoAdapterVar = toDoAdapter(todoList)
        rvTodo.adapter = toDoAdapterVar

        addBtnn.setOnClickListener{
            val newTask = etTask.text.toString()

            todoList.add(Model(newTask,false))
            toDoAdapterVar.notifyItemInserted(todoList.size- 1)

        }
    }


}