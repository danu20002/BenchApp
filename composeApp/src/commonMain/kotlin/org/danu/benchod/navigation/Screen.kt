package org.danu.benchod.navigation

 sealed interface Screen {
     data object Home:Screen
     data object Login:Screen
     data object SignUp:Screen
}