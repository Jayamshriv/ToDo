package com.example.todo


import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import kotlin.random.Random
import kotlin.random.Random.Default.nextInt


class toDoAdapter(
    var todoModel: ArrayList<Model>
) : RecyclerView.Adapter<toDoAdapter.todoHolder>() {


    inner class todoHolder(itemView: View) : RecyclerView.ViewHolder(itemView)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): todoHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.todo_items,parent,false)
        return todoHolder(view)

    }

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onBindViewHolder(holder: todoHolder, position: Int) {

        holder.itemView.findViewById<TextView>(R.id.textView). text = todoModel[position].taskText
        holder.itemView.findViewById<CheckBox>(R.id.checkBox).isChecked = todoModel[position].isChecked
        //holder.itemView.findViewById<CardView>(R.id.cView).getResources().getColor(getRandomColor(),null)
    }

   /* private fun getRandomColor(): Int {

        val colors = ArrayList<Int>()
        colors.add(R.color.blue)
        colors.add(R.color.purple_200)
        colors.add(R.color.purple_500)
        colors.add(R.color.fuchsia)
        colors.add(R.color.red)
        colors.add(R.color.lime)
        colors.add(R.color.teal)

        var rnd = Random
        return colors.get(rnd.nextInt(colors.size))

    }*/

    override fun getItemCount(): Int {
        return todoModel.size
    }


}