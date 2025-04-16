package com.red.evmovil.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.red.evmovil.home.HomeUI
import com.red.evmovil.searchBook.BookListUI
import com.red.evmovil.likedBooks.LikedBooksUI

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screens.Home.route
    ) {
        composable(Screens.Home.route) {
            HomeUI(
                onGoToSearch = { navController.navigate(Screens.Search.route) },
                onGoToLiked = { navController.navigate(Screens.Liked.route) }
            )
        }

        composable(Screens.Search.route) {
            BookListUI(
                onBack = { navController.popBackStack() }
            )
        }

        composable(Screens.Liked.route) {
            LikedBooksUI(
                onBack = { navController.popBackStack() }
            )
        }
    }
}