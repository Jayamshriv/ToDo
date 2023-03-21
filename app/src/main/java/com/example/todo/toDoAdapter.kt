package com.example.todo


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class toDoAdapter(
    var todoModel: MutableList<Model>
) : RecyclerView.Adapter<toDoAdapter.todoHolder>() {


    inner class todoHolder(itemView: View) : RecyclerView.ViewHolder(itemView)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): todoHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.todo_items,parent,false)
        return todoHolder(view)

    }

    override fun onBindViewHolder(holder: todoHolder, position: Int) {

        holder.itemView.findViewById<TextView>(R.id.textView). text = todoModel[position].taskText
        holder.itemView.findViewById<CheckBox>(R.id.checkBox).isChecked = todoModel[position].isChecked

    }

    override fun getItemCount(): Int {
        return todoModel.size
    }


}