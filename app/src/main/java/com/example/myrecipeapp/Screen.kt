package com.example.myrecipeapp

sealed class Screen(val route: String)   {
    object RecipeScreen : Screen("recipe_screen")
    object CategoryDetailsScreen : Screen("category_details_screen")

}