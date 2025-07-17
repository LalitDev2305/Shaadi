package com.assignment.shaadi

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.assignment.home.HomeScreen


const val splashRoute = "splash"
const val homeRoute = "home"

@Composable
fun ShaadiNavHost(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = splashRoute,
    ) {

        composable(splashRoute) {
            SplashScreen(
                onSplashFinished = {
                    navController.navigate(homeRoute) {
                        popUpTo(splashRoute) { inclusive = true }
                    }
                }
            )
        }

        composable(homeRoute) {
            HomeScreen(
                viewModel = hiltViewModel(),
                onAccept = { user -> Log.d("HomeScreen", "Accepted: ${user.status}") },
                onDecline = { user -> Log.d("HomeScreen", "Declined: ${user.status}") }
            )
        }
    }
}