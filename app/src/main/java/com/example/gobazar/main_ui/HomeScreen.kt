package com.example.gobazar.main_ui

import androidx.compose.runtime.*
import androidx.compose.material3.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.*
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.gobazar.login_signup_retrofict.AuthViewModel
import com.example.gobazar.login_signup_retrofict.userid.SessionManager

@Composable
fun HomeScreen(
    navController: NavController,viewModel: AuthViewModel

){


    Box(modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center){

        val context = LocalContext.current
        val session = SessionManager(context)

        val userId = session.getUserId()



//        Text("User ID: $userId" )





        if (userId==3){
            Text("User ID: $userId" )


        }else{



            Text("Err" )


        }




    }





}