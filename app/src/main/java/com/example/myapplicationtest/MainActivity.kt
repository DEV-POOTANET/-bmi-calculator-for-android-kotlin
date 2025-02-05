package com.example.myapplicationtest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myapplicationtest.ui.theme.MyApplicationTestTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTestTheme {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = "AgeScreen") {
                    composable("AgeScreen") { AgeScreen(navController) }
                    composable("BMIScreen") { BMIScreen(navController) }
                    composable("ShowBMI/{bmi}") { backStackEntry ->
                        val bmi = backStackEntry.arguments?.getString("bmi")
                        ShowBMI(navController, bmi ?: "0")
                    }
                }
//                AgeScreen(navController)
            }
        }
    }
}

