package com.example.apprendevcurso.room_database.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.apprendevcurso.EatsApp
import com.example.apprendevcurso.databinding.FoodFragmentBinding
import com.example.apprendevcurso.room_database.entities.FoodEntity
import com.example.apprendevcurso.room_database.ui.adapters.FoodActions
import com.example.apprendevcurso.room_database.ui.adapters.FoodAdapter
import kotlinx.coroutines.*

class FoodFragment : Fragment(), FoodActions {
    private lateinit var foods: MutableList<FoodEntity>
    private lateinit var binding: FoodFragmentBinding
    private val foodAdapter: FoodAdapter by lazy {
        FoodAdapter(this)
    }
    private var foodEntity = FoodEntity()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = with(FoodFragmentBinding.inflate(inflater, container, false)) {
        binding = this
        binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        foods = mutableListOf()
        getFoods()
        setUpComponent()
    }

    private fun setUpComponent() {
        updateAdapter()
        with(binding) {
            save.setOnClickListener {
                addFood(FoodEntity(foodName = food.text.toString()))
            }

            update.setOnClickListener {
                foodEntity.foodDescription = food.text.toString()
                updateFood(foodEntity)
            }

            delete.setOnClickListener { deleteFood(foodEntity) }
        }
    }

    private fun updateAdapter() {
        foodAdapter.submitList(foods)
        foodAdapter.notifyDataSetChanged()
        binding.foods.adapter = foodAdapter
    }

    private fun getFoods() {
        MainScope().launch {
            withContext(Dispatchers.Default) {
                foods = EatsApp.foodDatabase.foodDao().getAllFood()
            }
            updateAdapter()
        }
    }

    private fun addFood(foodEntity: FoodEntity) {
        MainScope().launch {
            withContext(Dispatchers.Default) {
                EatsApp.foodDatabase.foodDao().addFood(foodEntity)
                foods = EatsApp.foodDatabase.foodDao().getAllFood()
            }
            updateAdapter()
        }
    }

    private fun updateFood(foodEntity: FoodEntity) {
        MainScope().launch {
            withContext(Dispatchers.Default) {
                EatsApp.foodDatabase.foodDao().updateFood(foodEntity)
                getFoods()
            }
            updateAdapter()
        }
    }

    private fun deleteFood(foodEntity: FoodEntity) {
        MainScope().launch {
            withContext(Dispatchers.Default) {
                EatsApp.foodDatabase.foodDao().deleteFood(foodEntity)
                getFoods()
            }
            updateAdapter()
        }
    }

    override fun getFood(foodEntity: FoodEntity) {
        this.foodEntity = foodEntity
    }

}