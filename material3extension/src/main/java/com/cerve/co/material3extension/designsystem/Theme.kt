package com.cerve.co.material3extension.designsystem

import android.os.Build
import androidx.activity.ComponentActivity
import androidx.annotation.ChecksSdkIntAtLeast
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.Surface
import androidx.compose.material3.Typography
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.core.view.WindowCompat.setDecorFitsSystemWindows
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Composable
fun ExtendedTheme(
    darkColorScheme: ColorScheme,
    lightColorScheme: ColorScheme,
    modifier: Modifier = Modifier,
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    typographyTheme: Typography = ExtendedTheme.typography,
    content: @Composable (Modifier) -> Unit = { }
) {
    val context = LocalContext.current

    val colorScheme = when {
        dynamicColor && supportsDynamicTheming() -> {
            if (darkTheme) {
                dynamicDarkColorScheme(context)
            } else {
                dynamicLightColorScheme(context)
            }
        }
        darkTheme -> darkColorScheme
        else -> lightColorScheme
    }

    val systemUiController = rememberSystemUiController()

    LaunchedEffect(systemUiController, !darkTheme) {

        (context as ComponentActivity).apply {
            setDecorFitsSystemWindows(window, false)
        }

        // Update all of the system bar colors to be transparent, and use
        // dark icons if we're in light theme
        systemUiController.setSystemBarsColor(
            color = Color.Transparent,
            darkIcons = !darkTheme,
            isNavigationBarContrastEnforced = false
        )

    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = typographyTheme,
        content = {
            Surface(
                color = colorScheme.background
            ) { content(modifier.systemBarsPadding()) }
        }
    )
}

object ExtendedTheme {

    val colors: ColorScheme
        @Composable
        get() = MaterialTheme.colorScheme

    val typography: Typography
        @Composable
        get() = MaterialTheme.typography

    val shapes: Shapes
        @Composable
        get() = MaterialTheme.shapes

    val sizes: Sizes
        @Composable
        get() = LocalSizes.current

    val alphas: Alphas
        @Composable
        get() = LocalAlphas.current
}

@ChecksSdkIntAtLeast(api = Build.VERSION_CODES.S)
private fun supportsDynamicTheming() = Build.VERSION.SDK_INT >= Build.VERSION_CODES.S
