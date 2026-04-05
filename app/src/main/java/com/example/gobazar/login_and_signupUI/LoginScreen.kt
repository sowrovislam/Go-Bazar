package com.example.gobazar.login_and_signupUI

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
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
    var error by remember { mutableStateOf("") }

    val gradientBackground = Brush.verticalGradient(
        colors = listOf(
            Color(0xFF4F46E5),  // Indigo
            Color(0xFF7C3AED),  // Purple
            Color(0xFFDB2777)   // Pink
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

            // Top Section - Logo + Welcome
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.weight(1f)
            ) {
                Spacer(modifier = Modifier.height(40.dp))

                Image(
                    painter = painterResource(id = R.drawable.img),
                    contentDescription = "GoBazar Logo",
                    modifier = Modifier
                        .size(160.dp)
                        .clip(CircleShape)
                        .shadow(12.dp, CircleShape)
                )

                Spacer(modifier = Modifier.height(32.dp))

                Text(
                    text = "Welcome to GoBazar",
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = " Create lists and market profitably ✨",
                    fontSize = 17.sp,
                    color = Color.White.copy(alpha = 0.85f),
                    textAlign = TextAlign.Center
                )

                Spacer(modifier = Modifier.height(50.dp))

                // Input Fields in a Card
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

                        OutlinedTextField(
                            value = password,
                            onValueChange = { password = it },
                            label = { Text("Password") },
                            visualTransformation = PasswordVisualTransformation(),
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
                            ,
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)

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

            // Bottom Buttons
            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(14.dp)
            ) {

                // User Login - Gradient Button
                Button(
                    onClick = {
                        if (email == "user@gmail.com" && password == "1234") {
                            navController.navigate("user_home")
                            error = ""
                        } else {
                            error = "Invalid User Login"
                        }
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(56.dp),
                    shape = RoundedCornerShape(16.dp),
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
                        Text(
                            text = "Login as User",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = Color.White
                        )
                    }
                }

                // Admin Login
                Button(
                    onClick = {

                       navController.navigate(Screen.SignUpScreen.route)

                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(56.dp),
                    shape = RoundedCornerShape(16.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color.White.copy(alpha = 0.15f))
                ) {
                    Text(
                        text = "Login as Admin",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = Color.White
                    )
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