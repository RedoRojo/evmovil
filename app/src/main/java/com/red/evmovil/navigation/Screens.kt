package com.red.evmovil.navigation

sealed class Screens (
    val route: String
){
    object Home : Screens("home_screen")
    object Search : Screens("search_books_screen")
    object Liked : Screens("liked_books_screen")
}