package com.cerve.co.material3extension.designsystem

import android.app.Activity
import android.os.Build
import androidx.annotation.ChecksSdkIntAtLeast
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.core.view.WindowCompat.setDecorFitsSystemWindows
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Composable
fun ThemeWrapper(
    darkColorScheme: ColorScheme,
    lightColorScheme: ColorScheme,
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = false,
    decorFitsSystemWindows: Boolean = false,
    systemBarColor: Color = Color.Transparent,
    isNavigationBarContrastEnforced: Boolean = false,
    content: @Composable () -> Unit
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

    LaunchedEffect(Unit) {

        (context as Activity).apply {
            setDecorFitsSystemWindows(window, decorFitsSystemWindows)
        }

        // Update all of the system bar colors to be transparent, and use
        // dark icons if we're in light theme
        systemUiController.setSystemBarsColor(
            color = systemBarColor,
            darkIcons = !darkTheme,
            isNavigationBarContrastEnforced = isNavigationBarContrastEnforced
        )
    }

    MaterialTheme(colorScheme = colorScheme) {
        content()
    }

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

    val sizes: Size
        @Composable
        get() = LocalSizes.current

    val alphas: Alpha
        @Composable
        get() = LocalAlphas.current
}

@ChecksSdkIntAtLeast(api = Build.VERSION_CODES.S)
private fun supportsDynamicTheming() = Build.VERSION.SDK_INT >= Build.VERSION_CODES.S
