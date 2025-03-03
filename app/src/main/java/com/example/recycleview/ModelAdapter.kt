package com.example.recycleview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.recycleview.ModelAdapter.ModelViewHolder
import com.example.recycleview.databinding.Item2Binding

class ModelAdapter(private val model2s: List<Model2>) : RecyclerView.Adapter<ModelViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ModelViewHolder {
        val binding = Item2Binding.inflate(LayoutInflater.from(parent.context), parent, false)
        val modelViewHolder = ModelViewHolder(binding)
        return modelViewHolder
    }

    override fun onBindViewHolder(holder: ModelViewHolder, position: Int) {
        holder.bind(model2s[position])
    }

    override fun getItemCount(): Int {
        return model2s.size
    }

    class ModelViewHolder(private val binding: Item2Binding) : RecyclerView.ViewHolder(
        binding.root
    ) {
        fun bind(model: Model2) {
            binding.img.setImageResource(model.img)
            binding.img1.setImageResource(model.img1)
            binding.img2.setImageResource(model.img2)
            binding.img3.setImageResource(model.img3)
            binding.img4.setImageResource(model.img4)
            binding.img5.setImageResource(model.img5)
            binding.img6.setImageResource(model.img6)
            binding.bg.text = model.text
            Glide.with(super.itemView.context).load(model.img).into(binding.img)
        }
    }
}
