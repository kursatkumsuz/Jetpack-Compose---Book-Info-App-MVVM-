package com.kursatdrhistoryapp.ebookapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.kursatdrhistoryapp.ebookapp.view.screen.DetailScreen
import com.kursatdrhistoryapp.ebookapp.view.screen.HomeScreen


@Composable
fun BookNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = BookScreens.HomeScreen.name) {
        composable(BookScreens.HomeScreen.name) {
            HomeScreen(navController = navController)
        }
        composable(BookScreens.DetailScreen.name + "/{book}",
            arguments = listOf(
                navArgument(name = "book") { type = NavType.IntType }
            )) { backStrackEntry ->
            DetailScreen(
                navController,
                backStrackEntry.arguments?.getInt("book")
            )
        }
    }
}