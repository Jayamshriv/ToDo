package com.example.todo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MainActivity : AppCompatActivity() {



    private val todoList = ArrayList<Model>()


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rvTodo = findViewById<RecyclerView>(R.id.rvTodo)
        val addBtnn = findViewById<Button>(R.id.addBtn)
        val etTask= findViewById<EditText>(R.id.etTask)


        rvTodo.layoutManager = LinearLayoutManager(this)
        val toDoAdapterVar = toDoAdapter(todoList)
        rvTodo.adapter = toDoAdapterVar

        addBtnn.setOnClickListener{
            var newTask = etTask.text.toString()
            if(newTask != "") {
                todoList.add(Model(newTask, false))
                toDoAdapterVar.notifyItemInserted(todoList.size - 1)
                etTask.text.clear()
            }else{
                Toast.makeText(this,"Empty Task",Toast.LENGTH_SHORT).show()
            }
        }
    }


}