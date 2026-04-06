package com.example.gobazar.login_and_signupUI

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.example.gobazar.R
import com.example.gobazar.navagationUi.Screen

import kotlinx.coroutines.delay

@Composable
fun FastScreen(navController: NavController) {
    val gradientBackground = Brush.verticalGradient(
        colors = listOf(
            Color(0xFF4BE6F8),
            Color(0xFF697BEE),
            Color(0xFF8BC34A)
        )
    )


        var startAnimation by remember { mutableStateOf(false) }

    // ✅ Scale Animation
    val scale by animateFloatAsState(
        targetValue = if (startAnimation) 1f else 0.5f,
        animationSpec = tween(1000),
        label = ""
    )

    // ✅ Fade Animation
    val alpha by animateFloatAsState(
        targetValue = if (startAnimation) 1f else 0f,
        animationSpec = tween(1000),
        label = ""
    )

    // ✅ Start animation + navigate
    LaunchedEffect(Unit) {
        startAnimation = true
// 🔥 THIS WAS MISSI
        delay(2000)

        navController.navigate(Screen.LoginScreen.route) {
            popUpTo(Screen.FastScreen.route) { inclusive = true }
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(gradientBackground),
        contentAlignment = Alignment.Center
    ) {

        Image(
            painter = painterResource(R.drawable.img),
            contentDescription = "Image",
            modifier = Modifier
                .size(200.dp)
                .clip(CircleShape)
                .scale(scale)   // ✅ animation
                .alpha(alpha)   // ✅ animation
        )
    }

}

@Preview(showSystemUi = true)
@Composable
fun FastUI() {
    val navController = rememberNavController()
    FastScreen(navController)
}