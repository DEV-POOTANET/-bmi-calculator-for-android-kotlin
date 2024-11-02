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
fun BMIScreen(navController: NavController) {
    var textW by remember { mutableStateOf("") }
    var textH by remember { mutableStateOf("") }
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
            verticalArrangement = Arrangement.Top,
        ) {
            Spacer(modifier = Modifier.height(100.dp))
            Text(text = "BMI Calculator", fontSize = 25.sp,)
            Spacer(modifier = Modifier.height(10.dp))
            TextField(
                value = textW,
                onValueChange = { textW = it },
                label = { Text("น้ำหนัก กก.") },
                modifier = Modifier.fillMaxWidth(0.8f)
            )
            Spacer(modifier = Modifier.height(10.dp))
            TextField(
                value = textH,
                onValueChange = { textH = it },
                label = { Text("ส่วนสูง ซม.") },
                modifier = Modifier.fillMaxWidth(0.8f)
            )
            Spacer(modifier = Modifier.height(10.dp))
            Button(
                onClick = {
                    val weight = textW.toDoubleOrNull()
                    val height = textH.toDoubleOrNull()

                    if (weight != null && height != null) {
                        val heightInMeters = height / 100
                        val bmi = weight / (heightInMeters * heightInMeters)

                        navController.navigate("ShowBMI/$bmi")
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp)
                    .height(60.dp)
            ) {
                Text("Calculate >", fontSize = 20.sp)
            }
        }
    }
}