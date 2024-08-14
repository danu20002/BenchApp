package org.danu.benchod

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

import benchapp.composeapp.generated.resources.Res
import benchapp.composeapp.generated.resources.compose_multiplatform
import org.danu.benchod.auth.LoginScreen
import org.danu.benchod.auth.SignupScreen
import org.danu.benchod.navigation.Screen
import org.danu.benchod.navigation.SimpleNavController

@Composable
@Preview
fun App() {

    MaterialTheme {
        Surface(modifier = Modifier.fillMaxSize()) {
            val navController= remember { SimpleNavController(Screen.Login) }
            val currentSCreen by navController.currentscreen.collectAsState()
            when(currentSCreen){
                Screen.Home -> Screen.Home
                Screen.Login -> LoginScreen(navController=navController)
                Screen.SignUp -> SignupScreen(navController=navController)
            }

        }


    }
}