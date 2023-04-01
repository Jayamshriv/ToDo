package com.example.todo

import android.R.attr.action
import android.content.Context
import android.content.SharedPreferences
import com.google.gson.Gson
import android.os.Bundle
import android.view.Menu
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import android.widget.Toolbar
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.TypedArrayUtils.getString
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type


class MainActivity : AppCompatActivity() {


    private var todoList = ArrayList<Model>()


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        loadTasks()

/*
* Action Bar
*/
        val actionBar = supportActionBar

        actionBar?.displayOptions = ActionBar.DISPLAY_SHOW_CUSTOM
        actionBar?.setCustomView(R.layout.todo_action_bar)

//        val customView = actionBar?.customView?.parent as Toolbar
//        toolbar.setContentInsetsAbsolute(0, 0)
//        toolbar.contentInsetEnd
//        toolbar.setPadding(0, 0, 0, 0)

        actionBar?.setDisplayShowHomeEnabled(true)
        actionBar?.setDisplayUseLogoEnabled(true)

        fun onCreateOptionsMenu(menu: Menu?): Boolean {
            menuInflater.inflate(R.menu.action_bar, menu)
            return true
        }


        /*
        * Recycler View
        * */

        val rvTodo = findViewById<RecyclerView>(R.id.rvTodo)
        val addBtnn = findViewById<Button>(R.id.addBtn)
        val etTask = findViewById<EditText>(R.id.etTask)

        todoList=loadTasks()?: ArrayList()
        rvTodo.layoutManager = LinearLayoutManager(this)
        val toDoAdapterVar = toDoAdapter(todoList)
        rvTodo.adapter = toDoAdapterVar

        addBtnn.setOnClickListener {
            val newTask = etTask.text.toString()
            if (newTask != "") {

//                val myPref = getSharedPreferences("todo", MODE_PRIVATE)
//                val editor = myPref.edit()
//
//                val gson = Gson()
                todoList.add(Model(newTask, false))
                saveTasks()
//                val json = gson.toJson(todoList)
//                editor.putString("task", json)
//                editor.apply()


                toDoAdapterVar.notifyItemInserted(todoList.size - 1)
                etTask.text.clear()


            } else {
                Toast.makeText(this, "Empty Task", Toast.LENGTH_SHORT).show()
            }
        }

    }

//    fun loadTasks(): ArrayList<Model>? {
//
//        val myPref = getSharedPreferences("todo", MODE_PRIVATE)
//
//        val json = myPref.getString("task", null)
//
//        val type = object : TypeToken<ArrayList<Model>>() {}.type
//        val taskList = Gson().fromJson<ArrayList<Model>>(json, type)
//
//        if (taskList != null) {
//            return taskList
//
//        } else {
//            return ArrayList<Model>()
//        }


//    }
    private fun saveTasks() {
        val prefs = getSharedPreferences("todo", Context.MODE_PRIVATE)
        val editor = prefs.edit()
        val gson = Gson()
        val json = gson.toJson(todoList)
        editor.putString("tasks", json)
        editor.putBoolean("ischeck",true)
        editor.apply()
    }

    private fun loadTasks(): ArrayList<Model>? {
        val prefs = getSharedPreferences("todo", Context.MODE_PRIVATE)
        val gson = Gson()
        val json = prefs.getString("tasks", null)
        val type = object : TypeToken<ArrayList<Model>>() {}.type
        return gson.fromJson(json, type)
    }

}
