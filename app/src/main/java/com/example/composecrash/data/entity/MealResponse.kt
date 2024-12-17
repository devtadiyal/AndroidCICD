package com.example.composecrash.data.entity

data class MealsResponse(
    val meals: List<Meal>
)

data class Meal(
    val strMeal: String,
    val strMealThumb: String,
    val idMeal: String
)
