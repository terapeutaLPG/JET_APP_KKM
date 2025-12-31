package com.example.jet_app

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.ui.tooling.preview.Preview

enum class Screen {
    MENU,
    GAME,
    INSTRUCTIONS
}

@Composable
@Preview
fun App() {
    MaterialTheme {
        var currentScreen by remember { mutableStateOf(Screen.MENU) }

        when (currentScreen) {
            Screen.MENU -> MenuScreen(
                onStartClick = { currentScreen = Screen.GAME },
                onInstructionsClick = { currentScreen = Screen.INSTRUCTIONS }
            )
            Screen.GAME -> GameScreen(
                onBackClick = { currentScreen = Screen.MENU }
            )
            Screen.INSTRUCTIONS -> InstructionsScreen(
                onBackClick = { currentScreen = Screen.MENU }
            )
        }
    }
}

@Composable
fun MenuScreen(
    onStartClick: () -> Unit,
    onInstructionsClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .background(Color(0xFFC5B8E0))
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .safeContentPadding(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "FALLEN JET",
                fontSize = 48.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFFFFEB3B)
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "najlepszy wynik: 0",
                fontSize = 16.sp,
                color = Color.Black
            )
            Spacer(modifier = Modifier.height(24.dp))
            Button(
                onClick = onStartClick,
                modifier = Modifier.width(200.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF4CAF50)
                ),
                border = BorderStroke(2.dp, Color.Black)
            ) {
                Text(
                    text = "START",
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                )
            }
            Spacer(modifier = Modifier.height(12.dp))
            Button(
                onClick = onInstructionsClick,
                modifier = Modifier.width(200.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF2196F3)
                ),
                border = BorderStroke(2.dp, Color.Black)
            ) {
                Text(
                    text = "INSTRUKCJA",
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}

@Composable
fun GameScreen(onBackClick: () -> Unit) {
    Box(
        modifier = Modifier
            .background(Color.Black)
            .fillMaxSize()
    ) {
        Text(
            text = "▲",
            fontSize = 48.sp,
            color = Color.White,
            modifier = Modifier.align(Alignment.Center)
        )
    }
}

@Composable
fun InstructionsScreen(onBackClick: () -> Unit) {
    Box(
        modifier = Modifier
            .background(Color(0xFFC5B8E0))
            .fillMaxSize()
    ) {
    }
}