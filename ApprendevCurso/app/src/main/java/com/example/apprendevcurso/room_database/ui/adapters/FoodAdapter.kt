package com.example.apprendevcurso.room_database.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.apprendevcurso.R
import com.example.apprendevcurso.databinding.FoodHolderBinding
import com.example.apprendevcurso.room_database.entities.FoodEntity

class FoodAdapter(val foodActions: FoodActions) :
    ListAdapter<FoodEntity, FoodAdapter.ViewHolder>(COMPARATOR) {

    companion object {
        val COMPARATOR = object : DiffUtil.ItemCallback<FoodEntity>() {
            override fun areItemsTheSame(oldItem: FoodEntity, newItem: FoodEntity): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: FoodEntity, newItem: FoodEntity): Boolean {
                return oldItem == newItem
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder(
        DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.food_holder,
            parent,
            false
        )
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val food = getItem(position)
        with(holder.binding) {
            foodName.text = "La comida es: ${food.foodName}"
            foodDescription.text = "Es una comida de: ${food.foodDescription}"
            price.text = "El precio es: ${food.price}"
        }

        holder.itemView.setOnClickListener {
            foodActions.getFood(food)
        }
        holder.binding.executePendingBindings()
    }

    inner class ViewHolder(val binding: FoodHolderBinding) :
        RecyclerView.ViewHolder(binding.root)
}
