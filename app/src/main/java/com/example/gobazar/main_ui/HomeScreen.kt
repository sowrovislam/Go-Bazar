package com.example.gobazar.main_ui

import android.app.Activity
import android.util.Log
import android.view.Window
import androidx.compose.runtime.*
import androidx.compose.material3.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.view.WindowCompat
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.gobazar.login_signup_retrofict.AuthViewModel
import com.example.gobazar.login_signup_retrofict.userid.SessionManager
import com.example.gobazar.navagationUi.Screen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    navController: NavController,
    viewModel: AuthViewModel
) {
    val context = LocalContext.current
    val session = SessionManager(context)

    val userId = session.getUserId()
    val name = session.getUserName()



    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {

        // ✅ FIX: Use Compose Color (NOT android.graphics.Color)
        val appBarColor = Color.Gray

        // ✅ Status bar same color
        SetStatusBarColor(
            color = appBarColor,
            darkIcons = false
        )

        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text("Home") },

                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = appBarColor,
                        titleContentColor = Color.White
                    ),

                    // ✅ ADD THIS
                    actions = {

                        // 🔔 Notification Icon
                        IconButton(onClick = {


                        }) {
                            Icon(
                                imageVector = androidx.compose.material.icons.Icons.Default.Notifications,
                                contentDescription = "Notifications",
                                tint = Color.White,
                                modifier = Modifier.size(30.dp)
                            )
                        }

                        // 👤 Profile Icon
                        IconButton(onClick = {
                            navController.navigate(Screen.ProfileScreen.route)
                        }) {
                            Icon(
                                imageVector = androidx.compose.material.icons.Icons.Default.AccountCircle,
                                contentDescription = "Profile",
                                tint = Color.White,
                                modifier = Modifier.size(30.dp)
                            )
                        }
                    }
                )
            }
        ) { paddingValues ->

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {

                Text("Hello Jetpack Compose!")


                    Column {
                        Text("User ID: $userId")

                        Text("User ID: $name")


                    }

            }
        }
    }
}


// ✅ FULL IMPLEMENTATION (no TODO)
@Composable
fun SetStatusBarColor(color: Color, darkIcons: Boolean) {
    val view = LocalView.current

    SideEffect {
        val window: Window = (view.context as Activity).window
        window.statusBarColor = color.toArgb()

        WindowCompat.getInsetsController(window, view)
            .isAppearanceLightStatusBars = darkIcons
    }
}

@Preview(showSystemUi = true)
@Composable
fun HomePreview() {

    val navController = rememberNavController()
    val viewModel = AuthViewModel()

    HomeScreen(
        navController = navController,
        viewModel = viewModel
    )
}