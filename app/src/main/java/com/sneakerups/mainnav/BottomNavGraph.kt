package com.sneakerups.mainnav

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.sneakerups.CalendarScreen
import com.example.profile.ProfileScreen
import com.sneakerups.HomeScreen
import com.sneakerups.RankScreen

@Composable
fun BottomNavGraph(
    navController: NavHostController
){
    NavHost(navController = navController, startDestination = BottomNavSealedClass.Home.route, modifier = Modifier){
        composable(route = BottomNavSealedClass.Home.route){
            HomeScreen()
        }

        composable(route = BottomNavSealedClass.Calendar.route){
            CalendarScreen()
        }

        composable(route = BottomNavSealedClass.Rank.route){
            RankScreen()
        }

        composable(route = BottomNavSealedClass.Profile.route){
            ProfileScreen()
        }
    }


}