package org.danu.benchod.auth

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.danu.benchod.navigation.SimpleNavController

@Composable
fun SignupScreen(navController: SimpleNavController) {
    val scale by animateFloatAsState(targetValue = 1.05f, animationSpec = tween(durationMillis = 1500, easing = FastOutSlowInEasing))

    MaterialTheme {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text("Sign Up") },
                    navigationIcon = {
                        IconButton(onClick = {
                            navController.navigateBack()
                        }) {
                            Icon(
                                imageVector = Icons.Default.ArrowBack,
                                contentDescription = "Back"
                            )
                        }
                    },
                    backgroundColor = Color.Transparent,
                    contentColor = Color.Black, elevation = 0.dp
                )
            }
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(it), // Add padding for safe area
                contentAlignment = Alignment.Center
            ) {
                LazyColumn(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    contentPadding = PaddingValues(16.dp)
                ) {
                    item {
                        // Circular Image
                        Box(
                            modifier = Modifier
                                .size(100.dp)
                                .clip(CircleShape)
                                .background(Color.Transparent)
                                .border(1.dp, Color.Black, CircleShape)
                                .padding(8.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                imageVector = Icons.Default.Home,
                                contentDescription = null,
                                tint = Color.Blue,
                                modifier = Modifier
                                    .size(60.dp)
                                    .graphicsLayer(scaleX = scale, scaleY = scale)
                            )
                            // Add your image here if needed
                        }

                        Spacer(modifier = Modifier.height(16.dp))

                        // Input Fields
                        InputField(hint = "First Name")
                        Spacer(modifier = Modifier.height(8.dp))
                        InputField(hint = "Last Name")
                        Spacer(modifier = Modifier.height(8.dp))
                        InputField(hint = "Phone Number", keyboardType = KeyboardType.Phone)
                        Spacer(modifier = Modifier.height(8.dp))
                        InputField(hint = "Email", keyboardType = KeyboardType.Email)

                        Spacer(modifier = Modifier.height(16.dp))

                        // Sign Up Button
                        Button(
                            onClick = {
                                // Handle sign-up
                            },
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 16.dp, vertical = 15.dp),
                            colors = ButtonDefaults.buttonColors(backgroundColor = Color.Blue),
                            shape = RoundedCornerShape(8.dp)
                        ) {
                            Text("Sign Up", color = Color.White)
                        }

                        Spacer(modifier = Modifier.height(16.dp))


                        Row {
                            Text(
                                text = "Already have an account? ",
                                color = Color.Black,
                                fontSize = 16.sp,
                                modifier = Modifier.padding(2.dp))

                            Text(
                                text = "Login",
                                color = Color.Blue,
                                fontSize = 16.sp,
                                modifier = Modifier
                                    .clickable {
                                        // Navigate to login screen
                                        navController.navigateBack()
                                    }
                                    .padding(2.dp)
                            )
                        }
                        // Login Text

                    }
                }
            }
        }
    }
}

@Composable
fun InputField(
    hint: String,
    keyboardType: KeyboardType = KeyboardType.Text
) {
    var text by remember { mutableStateOf("") }

    OutlinedTextField(
        value = text,
        onValueChange = { text = it },
        placeholder = { Text(text = hint, color = Color.Gray) },
        visualTransformation = PasswordVisualTransformation(),
        keyboardOptions = KeyboardOptions.Default.copy(keyboardType = keyboardType),
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp),
        shape = RoundedCornerShape(8.dp),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedLabelColor = Color.Blue,
            cursorColor = Color.Blue,
            placeholderColor = Color.Gray
        )
    )
}
