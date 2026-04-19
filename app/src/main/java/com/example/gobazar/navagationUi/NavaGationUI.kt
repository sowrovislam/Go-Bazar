package com.example.gobazar.navagationUi


import android.content.Context
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.gobazar.login_and_signupUI.FastScreen
import com.example.gobazar.login_and_signupUI.ForgotPassScreen
import com.example.gobazar.login_and_signupUI.LoginScreen
import com.example.gobazar.login_and_signupUI.SignupScreen
import com.example.gobazar.login_signup_retrofict.AuthViewModel
import com.example.gobazar.main_ui.HomeScreen


@Composable
fun NavaGationUI(context: Context) {
    val pref = context.getSharedPreferences("USER_SESSION", Context.MODE_PRIVATE)
    val isLoggedIn = pref.getBoolean("isLoggedIn", false)

    val start = if (isLoggedIn) Screen.HomeScreen.route else Screen.LoginScreen.route


    val navController = rememberNavController()
    val viewModel: AuthViewModel = viewModel()
    NavHost(
        navController = navController,
        startDestination =start
    ) {

        composable(Screen.FastScreen.route) {
            FastScreen(navController)
        }

        composable(Screen.LoginScreen.route) {
            LoginScreen(navController,viewModel)
        }

        composable(Screen.SignUpScreen.route) {
            SignupScreen(navController,viewModel)
        }

        composable(Screen.ForgotPassScreen .route) {
            ForgotPassScreen(navController)
        }

        composable(Screen.HomeScreen.route){
            HomeScreen(navController)
        }


        composable(Screen.Add_List_Screen.route) {
//            Add_List_Screen(navController)
        }

    }
}

sealed class Screen(val route: String) {

    object FastScreen : Screen("FastScreen")

    object LoginScreen : Screen("LoginScreen")

    object SignUpScreen : Screen("SignUpScreen")

    object ForgotPassScreen : Screen("ForgotPassScreen")

    object HomeScreen : Screen("HomeScreen")

    object Add_List_Screen : Screen("Add_List_Screen")


}