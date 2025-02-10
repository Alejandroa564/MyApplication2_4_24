package com.example.myapplication2_4_24

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            QuizApp()
        }
    }
}

@Composable
fun QuizApp() {
    var answerState by remember { mutableStateOf<String?>(null) }
    val question = "Is the sky blue?"

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = question, fontSize = 24.sp, modifier = Modifier.padding(16.dp))
        Spacer(modifier = Modifier.height(16.dp))
        Row {
            Button(onClick = { answerState = "Correct!" }) {
                Text("True")
            }
            Spacer(modifier = Modifier.width(16.dp))
            Button(onClick = { answerState = "Incorrect!" }) {
                Text("False")
            }
        }
        answerState?.let {
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = it, fontSize = 20.sp)
        }
    }
}
