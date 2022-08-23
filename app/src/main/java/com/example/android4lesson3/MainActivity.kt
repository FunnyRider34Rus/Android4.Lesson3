package com.example.android4lesson3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.android4lesson3.ui.navigation.NavGraph
import com.example.android4lesson3.ui.screens.CounterViewModel
import com.example.android4lesson3.ui.theme.Android4Lesson3Theme
import com.example.android4lesson3.ui.screens.MainScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Android4Lesson3Theme {
                App()
            }
        }
    }
}

@Composable
fun App() {
    val navController = rememberNavController()
    val viewModel : CounterViewModel = viewModel()
    NavHost(navController = navController, startDestination = NavGraph.Main.name) {
        composable(NavGraph.Main.name) {
            MainScreen(viewModel = viewModel) }
    }
}