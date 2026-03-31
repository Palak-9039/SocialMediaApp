package com.example.finalproject.presentation.Navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.finalproject.presentation.Screen.MainScreen
import com.example.finalproject.presentation.Screen.Notification
import com.example.finalproject.presentation.Screen.Profile
import com.example.finalproject.presentation.Screen.ProfileSettingScreen
import com.example.finalproject.presentation.Screen.AddThread
import com.example.finalproject.presentation.Screen.ChangePasswordScreen
import com.example.finalproject.presentation.Screen.EditProfileScreen
import com.example.finalproject.presentation.Screen.bottomNavigation
import com.example.finalproject.presentation.Screen.commentScreen
import com.example.finalproject.presentation.Screen.login
import com.example.finalproject.presentation.Screen.otherprofile
import com.example.finalproject.presentation.Screen.register
import com.example.finalproject.presentation.Screen.search
import com.example.finalproject.presentation.Screen.splash
import com.example.finalproject.presentation.ViewModel.AuthViewModel
import com.example.finalproject.presentation.ViewModel.HomeViewModel
import com.example.finalproject.presentation.ViewModel.ProfileSettingsViewModel
import com.example.finalproject.presentation.ViewModel.SearchViewModel
import com.example.finalproject.presentation.ViewModel.ThreadViewModel
import com.example.finalproject.presentation.ViewModel.UserViewModel


@Composable
fun navigation (){
    val navController = rememberNavController()
    val authViewModel : AuthViewModel = viewModel()
    val threadViewModel : ThreadViewModel = viewModel()
    val homeViewModel : HomeViewModel = viewModel()
    val userViewModel : UserViewModel = viewModel()
    val searchViewModel : SearchViewModel = viewModel()
    val profileSettingsViewmodel : ProfileSettingsViewModel = viewModel()

    NavHost(navController = navController,startDestination = Screens.Splash.route){
        composable(Screens.Splash.route){
            splash(navController,authViewModel)
        }
        composable(Screens.BottomNavigation.route){
            bottomNavigation(navController)
        }
        composable(Screens.Home.route){
            MainScreen(navController,homeViewModel,threadViewModel)
        }
        composable(Screens.Search.route){
            search(navController,searchViewModel)
        }
        composable(Screens.Notification.route){
            Notification(navController)
        }
        composable(Screens.AddThread.route){
            AddThread(navController,threadViewModel)
        }
        composable(Screens.Profile.route){
            Profile(navController,authViewModel,threadViewModel,userViewModel)
        }
        composable(Screens.SignIn.route){
            login( navController,authViewModel)

        }
        composable(Screens.SignUp.route){
            register(navController,authViewModel)
        }
        composable(Screens.ProfileSettingScreen.route){
            ProfileSettingScreen(
                navController = navController
            )
        }
        composable(Screens.OtherProfile.route + "/{id}"){
            var id = it.arguments!!.get("id").toString()
            println("id " + id)
            id?.let {
                otherprofile(navController,userViewModel,authViewModel,threadViewModel,id)
            }
        }
        composable(Screens.EditProfileScreen.route){
            EditProfileScreen(
//                viewModel = profileSettingsViewmodel,
//                navController = navController
            )
        }
        composable(Screens.CommentsScreen.route+ "/{threadId}"){
            var threadId = it.arguments!!.get("threadId").toString()
            commentScreen(threadId,navController,threadViewModel)
        }
        composable(Screens.ChangePasswordScreen.route){
            ChangePasswordScreen(
                onChangePasswordClick = {}
            )
        }
    }
}