package com.example.diaryapp.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.diaryapp.presentation.AuthViewModel
import com.example.diaryapp.presentation.screens.auth.AuthenticationScreen
import com.example.diaryapp.utils.Constants.WRITE_SCREEN_ARGUMENT_KEY


@Composable
fun SetUpNavGraph(
    startDestination: String,
    navController: NavHostController,
    authViewModel : AuthViewModel = hiltViewModel()
){
    NavHost(
        startDestination = startDestination,
        navController = navController
    ){
        authenticationRoute(authViewModel)
        homeRoute()
        writeRoute()
    }
}

fun NavGraphBuilder.authenticationRoute(authViewModel: AuthViewModel){
    composable(route = Screen.Authentication.route){
        AuthenticationScreen(
            loadingState = false,
            onButtonClicked = {
                authViewModel.oneTapSignIn()
            },
            authViewModel
        )
    }
}

fun NavGraphBuilder.homeRoute(){
    composable(route = Screen.Home.route){

    }
}

fun NavGraphBuilder.writeRoute(){
    composable(
        route = Screen.Write.route,
        arguments = listOf(navArgument(name = WRITE_SCREEN_ARGUMENT_KEY){
            type = NavType.StringType
            nullable = true
            defaultValue = null
        })
    ){

    }
}