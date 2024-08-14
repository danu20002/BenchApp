package org.danu.benchod.auth

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.danu.benchod.component.LoadingScreen
import org.danu.benchod.navigation.Screen
import org.danu.benchod.navigation.SimpleNavController
import org.jetbrains.compose.ui.tooling.preview.Preview
@Composable
fun LoginScreen(navController: SimpleNavController) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var isLoading by remember { mutableStateOf(false) }
    val scope = rememberCoroutineScope()

    if (isLoading) {
        LoadingScreen()
    } else {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            contentAlignment = Alignment.Center
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = "Login", style = MaterialTheme.typography.h4)

                Spacer(modifier = Modifier.height(16.dp))

                OutlinedTextField(
                    value = email,
                    onValueChange = { email = it },
                    label = { Text("Email") },
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(8.dp))

                OutlinedTextField(
                    value = password,
                    onValueChange = { password = it },
                    label = { Text("Password") },
                    visualTransformation = PasswordVisualTransformation(),
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(16.dp))

                Button(
                    onClick = {
                        isLoading = true
                        // Simulate a network call or long-running operation
                        scope.launch {
                            // Simulate delay
                            delay(5000)
                            // Handle login logic here, then set isLoading to false when done
                            isLoading = false
                            // Navigate to the home screen
                            navController.navigateTo(Screen.SignUp)
                            // Example: navController.navigateTo(Screen.Home) if login is successful
                        }
                    },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(text = "Submit")
                }

                Spacer(modifier = Modifier.height(16.dp))

                Text(text = "Don't have an account?")
                TextButton(onClick = { navController.navigateTo(Screen.SignUp) }) {
                    Text(text = "Sign up")
                }
            }
        }
    }
}
