package com.cerve.co.cerveui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.core.view.WindowCompat.setDecorFitsSystemWindows
import com.cerve.co.cerveui.ui.theme.DarkColorScheme
import com.cerve.co.cerveui.ui.theme.LightColorScheme
import com.cerve.co.material3extension.designsystem.ExtendedTheme

class MainActivity : ComponentActivity() {

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setDecorFitsSystemWindows(window, false)

        setContent {
            ExtendedTheme(
                darkColorScheme = DarkColorScheme,
                lightColorScheme = LightColorScheme
            ) { contentModifier ->
                // A surface container using the 'background' color from the theme

                Scaffold(
                    modifier = contentModifier
                ) { innerPadding ->

                    Box(
                        modifier = Modifier
                            .padding(innerPadding)
                            .fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(text = "Hello World")
                    }
                }
            }
        }
    }
}
