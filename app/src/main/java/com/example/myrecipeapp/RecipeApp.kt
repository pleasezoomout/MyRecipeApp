package com.example.myrecipeapp

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import eu.tutorials.myrecipeapp.MainViewModel
import eu.tutorials.myrecipeapp.RecipeScreen

@Composable
fun RecipeApp(navController: NavHostController){
    val recipeViewModel: MainViewModel = viewModel()
    val state by recipeViewModel.categoriesState

    NavHost(navController = navController, startDestination = Screen.RecipeScreen.route) {

        composable(route = Screen.RecipeScreen.route) {
            RecipeScreen(viewstate = state, navitageToDetails = {
                navController.currentBackStackEntry?.savedStateHandle?.set( "cat", it)
                navController.navigate(Screen.CategoryDetailsScreen.route)
            })
        }

        composable(route = Screen.CategoryDetailsScreen.route) {
            val category = navController.previousBackStackEntry?.savedStateHandle?.get<Category>("cat") ?: Category("", "", "", "")
            CategoryDetailsScreen(category = category)
        }
    }
}