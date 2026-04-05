package com.example.gobazar.login_and_signupUI

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons

import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.gobazar.R
import com.example.gobazar.navagationUi.Screen

@Composable
fun LoginScreen(navController: NavController) {

    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }
    var error by remember { mutableStateOf("") }

    val gradientBackground = Brush.verticalGradient(
        colors = listOf(
            Color(0xFF4F46E5),
            Color(0xFF7C3AED),
            Color(0xFFDB2777)
        )
    )
// sowrov islam
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(gradientBackground)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {

            // Top Section: Logo + Welcome + Input Card
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Spacer(modifier = Modifier.height(40.dp))

                // Logo
                Image(
                    painter = painterResource(id = R.drawable.img),
                    contentDescription = "GoBazar Logo",
                    modifier = Modifier
                        .size(150.dp)
                        .clip(CircleShape)
                        .shadow(16.dp, CircleShape)
                )

                Spacer(modifier = Modifier.height(24.dp))

                Text(
                    text = "Welcome to GoBazar",
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = "Sign in to continue shopping & selling",
                    fontSize = 16.sp,
                    color = Color.White.copy(alpha = 0.85f),
                    textAlign = TextAlign.Center
                )

                Spacer(modifier = Modifier.height(40.dp))

                // Input Card
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(24.dp),
                    colors = CardDefaults.cardColors(containerColor = Color.White),
                    elevation = CardDefaults.cardElevation(defaultElevation = 12.dp)
                ) {
                    Column(
                        modifier = Modifier.padding(24.dp)
                    ) {

                        // Email Field
                        OutlinedTextField(
                            value = email,
                            onValueChange = { email = it },
                            label = { Text("Email Address") },
                            modifier = Modifier.fillMaxWidth(),
                            singleLine = true,
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                            colors = OutlinedTextFieldDefaults.colors(
                                focusedBorderColor = Color(0xFF6366F1),
                                focusedLabelColor = Color(0xFF6366F1)
                            )
                        )

                        Spacer(modifier = Modifier.height(16.dp))

                        // Password Field with Visibility Toggle
                        OutlinedTextField(
                            value = password,
                            onValueChange = { password = it },
                            label = { Text("Password") },
                            visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                            modifier = Modifier.fillMaxWidth(),
                            singleLine = true,
                            trailingIcon = {
                                IconButton(onClick = { passwordVisible = !passwordVisible }) {
//                                    Icon(
//                                        imageVector = if (passwordVisible) Icons.Filled.Visibility else Icons.Filled.VisibilityOff,
//                                        contentDescription = if (passwordVisible) "Hide password" else "Show password"
//                                    )
                                }
                            },
                            colors = OutlinedTextFieldDefaults.colors(
                                focusedBorderColor = Color(0xFF6366F1),
                                focusedLabelColor = Color(0xFF6366F1)
                            )
                        )

                        Spacer(modifier = Modifier.height(8.dp))

                        if (error.isNotEmpty()) {
                            Text(
                                text = error,
                                color = Color.Red,
                                fontSize = 14.sp
                            )
                        }

//                        Spacer(modifier = Modifier.height(8.dp))
//
//                        // Forgot Password
//                        Row(
//                            modifier = Modifier.fillMaxWidth(),
//                            horizontalArrangement = Arrangement.End
//                        ) {
//                            TextButton(onClick = { /* TODO: Add forgot password logic */ }) {
//                                Text(
//                                    "Forgot Password?",
//                                    color = Color(0xFF6366F1),
//                                    fontWeight = FontWeight.Medium
//                                )
//                            }
//                        }
                    }
                }
            }

            // Bottom Section: Buttons + Admin Signup
            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {

                // Two Login Buttons (side by side)
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {

                    // User Login Button
                    Button(
                        onClick = {
                            if (email == "user@gmail.com" && password == "1234") {
                                navController.navigate(Screen.HomeScreen.route)
                                error = ""
                            } else {
                                error = "Invalid User Login"
                            }
                        },
                        modifier = Modifier
                            .weight(1f)
                            .height(56.dp),
                        shape = RoundedCornerShape(16.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF6366F1))
                    ) {
                        Text(
                            text = "User Login",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.SemiBold
                        )
                    }

                    // Admin Login Button
                    Button(
                        onClick = {
                            if (email == "admin@gmail.com" && password == "admin123") {
                                navController.navigate(Screen.HomeScreen.route)
                                error = ""
                            } else {
                                error = "Invalid Admin Login"
                            }
                        },
                        modifier = Modifier
                            .weight(1f)
                            .height(56.dp),
                        shape = RoundedCornerShape(16.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFEF4444))
                    ) {
                        Text(
                            text = "Admin Login",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = Color.White
                        )
                    }
                }

                // Admin Sign Up Link
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Don't have an admin account? ",
                        color = Color.White.copy(alpha = 0.9f),
                        fontSize = 15.sp
                    )
                    TextButton(
                        onClick = {
                            navController.navigate(Screen.SignUpScreen.route)
                        }
                    ) {
                        Text(
                            text = "Sign up here",
                            color = Color.White,
                            fontWeight = FontWeight.Bold,
                            fontSize = 15.sp
                        )
                    }
                }
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun loginUI() {
    val navController = rememberNavController()
    LoginScreen(navController)
}