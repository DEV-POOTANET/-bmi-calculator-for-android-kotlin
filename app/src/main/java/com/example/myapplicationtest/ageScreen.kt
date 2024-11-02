package com.example.myapplicationtest

import android.annotation.SuppressLint
import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.compose.ui.platform.LocalContext

@Composable
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
fun AgeScreen(navController: NavController) {
    var textAge by remember { mutableStateOf("") }
    val context = LocalContext.current

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
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Spacer(modifier = Modifier.height(50.dp))
            Text(text = "Enter your Age?", fontSize = 25.sp)

            TextField(
                value = textAge,
                onValueChange = { textAge = it },
                label = { Text("Your age") },
                modifier = Modifier.fillMaxWidth(0.8f)
            )
            Spacer(modifier = Modifier.height(10.dp))
            Button(
                onClick = {
                    val age = textAge.toIntOrNull()
                    if (age != null) {
                        if (age > 18) {
                            navController.navigate("BMIScreen")
                        } else {
                            showToast(context, "อายุไม่ถึง")
                        }
                    } else {
                        showToast(context, "กรุณากรอกอายุให้ถูกต้อง")
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp)
                    .height(60.dp)
            ) {
                Text("Next >", fontSize = 20.sp)
            }
        }
    }
}

private fun showToast(context: Context, message: String) {
    Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
}

@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun MyTopBar() {
    TopAppBar(
        title = {
            Text(
                text = "BMI Application",
                color = Color.White
            )
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color(0xFF7FCDE1)
        ),
        navigationIcon = { Icon(Icons.Default.List, contentDescription = null, tint = Color.White) }
    )
}
