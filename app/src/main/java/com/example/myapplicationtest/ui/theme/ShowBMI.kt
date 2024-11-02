package com.example.myapplicationtest

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")

fun ShowBMI(navController: NavController, bmi: String) {
    val bmiValue = bmi.toDoubleOrNull() ?: 0.0
    val category = when {
        bmiValue < 18.5 -> "Underweight"
        bmiValue in 18.5..24.9 -> "Normal weight"
        bmiValue in 25.0..29.9 -> "Overweight"
        else -> "Obesity"
    }

    Scaffold(
        topBar = {
            MyTopBar()
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {
            Text(text = "Your BMI is: %.2f".format(bmiValue), fontSize = 25.sp)
            Spacer(modifier = Modifier.height(10.dp))
            Text(text = "Category: $category", fontSize = 20.sp)
            Spacer(modifier = Modifier.height(50.dp))
            Button(
                onClick = {

                        navController.navigate("BMIScreen")
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp)
                    .height(60.dp)
            ) {
                Text("BACK >", fontSize = 20.sp)
            }
        }
    }
}