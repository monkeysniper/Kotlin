package com.example.recycleview

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class Adapter(private val list: MutableList<Model>) :
    RecyclerView.Adapter<Adapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        val view1 = LayoutInflater.from(parent.context).inflate(R.layout.item2, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val model = list[position]
        holder.imageView.setImageResource(model.img)
        holder.textView.text = model.text

        if (model.isFirst) {
            holder.imageView1.setImageResource(R.drawable.border2)
            holder.textView.setTextColor(Color.RED)
        } else {
            holder.imageView1.setImageResource(R.drawable.border3)
            holder.textView.setTextColor(Color.BLACK)
        }
        holder.itemView.setOnClickListener { v: View? ->
            moveItem(holder.adapterPosition)
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imageView: ImageView =
            itemView.findViewById(R.id.burger)
        var imageView1: ImageView =
            itemView.findViewById(R.id.border)
        var textView: TextView = itemView.findViewById(R.id.bg)
    }

    fun moveItem(position: Int) {
        if (position == 0) return

        if (!list.isEmpty()) {
            list[0].isFirst = false
        }

        val item = list.removeAt(position)
        item.isFirst = true
        list.add(0, item)

        notifyItemMoved(position, 0)
        notifyItemChanged(0)
        notifyItemRangeChanged(0, position + 1)
    }

    fun moveItemToTopByName(dishName: String?) {
        var foundPosition = -1

        for (i in list.indices) {
            if (list[i].text.equals(dishName, ignoreCase = true)) {
                foundPosition = i
                break
            }
        }

        if (foundPosition == -1) {
            return
        }

        if (!list.isEmpty()) {
            list[0].isFirst = false
        }

        val item = list.removeAt(foundPosition)
        item.isFirst = true
        list.add(0, item)

        notifyItemMoved(foundPosition, 0)
        notifyItemRangeChanged(0, foundPosition + 1)
    }
}

