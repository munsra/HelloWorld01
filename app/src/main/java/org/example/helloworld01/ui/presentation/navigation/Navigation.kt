package org.example.helloworld01.ui.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import org.example.helloworld01.ui.presentation.screens.HomePage
import org.example.helloworld01.ui.presentation.screens.MainPage

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = "Home"
    ) {
        composable(route = "Home") {
            HomePage(
                onNextPage = {
                    navController.navigate("MainPage")
                }
            )
        }
        composable(route = "MainPage") {
            MainPage()
        }
    }
}