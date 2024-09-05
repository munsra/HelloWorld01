package org.example.helloworld01.ui.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import org.example.helloworld01.ui.presentation.screens.HomePage
import org.example.helloworld01.ui.presentation.screens.mainpage.MainPage

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Route.MAIN_PAGE
    ) {
        composable(route = Route.HOME_PAGE) {
            HomePage(
                onNextPage = {
                    navController.navigate(Route.MAIN_PAGE)
                }
            )
        }
        composable(route = Route.MAIN_PAGE) {
            MainPage()
        }
    }
}