package com.example.gobazar.login_and_signupUI


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh

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
fun SignupScreen(navController: NavController) {

    var fullName by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }
    var confirmPasswordVisible by remember { mutableStateOf(false) }
    var error by remember { mutableStateOf("") }
    var isLoading by remember { mutableStateOf(false) }

    val gradientBackground = Brush.verticalGradient(
        colors = listOf(
            Color(0xFF4F46E5),
            Color(0xFF7C3AED),
            Color(0xFFDB2777)
        )
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(gradientBackground)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {

            // Top Section
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.weight(1f)
            ) {
                Spacer(modifier = Modifier.height(20.dp))

                Image(
                    painter = painterResource(id = R.drawable.img),
                    contentDescription = "GoBazar Logo",
                    modifier = Modifier
                        .size(140.dp)
                        .clip(CircleShape)
                        .shadow(12.dp, CircleShape)
                )

                Spacer(modifier = Modifier.height(22.dp))

                Text(
                    text = "Admin Signup",
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = "Create your admin account",
                    fontSize = 17.sp,
                    color = Color.White.copy(alpha = 0.85f),
                    textAlign = TextAlign.Center
                )

                Spacer(modifier = Modifier.height(30.dp))

                // Input Card
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(20.dp),
                    colors = CardDefaults.cardColors(containerColor = Color.White),
                    elevation = CardDefaults.cardElevation(defaultElevation = 12.dp)
                ) {
                    Column(
                        modifier = Modifier
                            .padding(24.dp)
                            .fillMaxWidth()
                    ) {

                        // Full Name
                        OutlinedTextField(
                            value = fullName,
                            onValueChange = { fullName = it },
                            label = { Text("Full Name") },
                            modifier = Modifier.fillMaxWidth(),
                            singleLine = true,
                            colors = OutlinedTextFieldDefaults.colors(

                                // ✍️ Text color inside field
                                focusedTextColor = Color.Black,
                                unfocusedTextColor = Color.Gray,

                                // 🏷 Label color
                                focusedLabelColor = Color.Blue,
                                unfocusedLabelColor = Color.Gray,

                                // 🟦 Border color
                                focusedBorderColor = Color.Blue,
                                unfocusedBorderColor = Color.LightGray,

                                // ✨ Cursor color
                                cursorColor = Color.Blue
                            )
                        )

                        Spacer(modifier = Modifier.height(16.dp))

                        // Email
                        OutlinedTextField(
                            value = email,
                            onValueChange = { email = it },
                            label = { Text("Email Address") },
                            modifier = Modifier.fillMaxWidth(),
                            singleLine = true,
                            colors = OutlinedTextFieldDefaults.colors(

                                // ✍️ Text color inside field
                                focusedTextColor = Color.Black,
                                unfocusedTextColor = Color.Gray,

                                // 🏷 Label color
                                focusedLabelColor = Color.Blue,
                                unfocusedLabelColor = Color.Gray,

                                // 🟦 Border color
                                focusedBorderColor = Color.Blue,
                                unfocusedBorderColor = Color.LightGray,

                                // ✨ Cursor color
                                cursorColor = Color.Blue
                            )
                        )

                        Spacer(modifier = Modifier.height(16.dp))

                        // Password
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
//                                        contentDescription = "Toggle Password"
//                                    )
                                }
                            },
                            colors = OutlinedTextFieldDefaults.colors(

                                // ✍️ Text color inside field
                                focusedTextColor = Color.Black,
                                unfocusedTextColor = Color.Gray,

                                // 🏷 Label color
                                focusedLabelColor = Color.Blue,
                                unfocusedLabelColor = Color.Gray,

                                // 🟦 Border color
                                focusedBorderColor = Color.Blue,
                                unfocusedBorderColor = Color.LightGray,

                                // ✨ Cursor color
                                cursorColor = Color.Blue
                            )
                        )

                        Spacer(modifier = Modifier.height(16.dp))

                        // Confirm Password
                        OutlinedTextField(
                            value = confirmPassword,
                            onValueChange = { confirmPassword = it },
                            label = { Text("Confirm Password") },
                            visualTransformation = if (confirmPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                            modifier = Modifier.fillMaxWidth(),
                            singleLine = true,
                            trailingIcon = {
                                IconButton(onClick = {
                                    confirmPasswordVisible = !confirmPasswordVisible
                                }) {
//                                    Icon(
//                                        imageVector = if (confirmPasswordVisible) Icons.Filled.Refresh else Icons.Filled.Refresh,
//                                        contentDescription = "Toggle Confirm Password"
//                                    )
                                }
                            },
                            colors = OutlinedTextFieldDefaults.colors(

                                // ✍️ Text color inside field
                                focusedTextColor = Color.Black,
                                unfocusedTextColor = Color.Gray,

                                // 🏷 Label color
                                focusedLabelColor = Color.Blue,
                                unfocusedLabelColor = Color.Gray,

                                // 🟦 Border color
                                focusedBorderColor = Color.Blue,
                                unfocusedBorderColor = Color.LightGray,

                                // ✨ Cursor color
                                cursorColor = Color.Blue
                            )
                        )

                        Spacer(modifier = Modifier.height(12.dp))

                        if (error.isNotEmpty()) {
                            Text(
                                text = error,
                                color = Color.Red,
                                fontSize = 14.sp
                            )
                        }
                    }
                }
            }

            // Bottom Section - Signup Button
            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Button(
                    onClick = {
                        isLoading = true
                        error = ""

                        when {
                            fullName.isBlank() -> error = "Please enter your full name"
                            email.isBlank() -> error = "Please enter your email"
                            password.isBlank() -> error = "Please enter a password"
                            password.length < 6 -> error = "Password must be at least 6 characters"
                            password != confirmPassword -> error = "Passwords do not match"
                            else -> {
                                // Simulate successful signup (you can replace with real backend logic)
                                navController.navigate(Screen.HomeScreen)
                            }
                        }
                        isLoading = false
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(56.dp),
                    shape = RoundedCornerShape(16.dp),
                    enabled = !isLoading,
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
                    contentPadding = PaddingValues(0.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(
                                brush = Brush.horizontalGradient(
                                    colors = listOf(Color(0xFF22D3EE), Color(0xFF6366F1))
                                )
                            ),
                        contentAlignment = Alignment.Center
                    ) {
                        if (isLoading) {
                            CircularProgressIndicator(color = Color.White, strokeWidth = 3.dp)
                        } else {
                            Text(
                                text = "Create Admin Account",
                                fontSize = 18.sp,
                                fontWeight = FontWeight.SemiBold,
                                color = Color.White
                            )
                        }
                    }
                }

                // Login Link
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Already have an account? ",
                        color = Color.White.copy(alpha = 0.9f),
                        fontSize = 15.sp
                    )
                    TextButton(onClick = {
                        navController.navigate(Screen.LoginScreen.route)
                    }) {
                        Text(
                            text = "Login",
                            color = Color.White,
                            fontWeight = FontWeight.SemiBold,
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
fun AdminSignupPreview() {
    val navController = rememberNavController()
    SignupScreen(navController)
}