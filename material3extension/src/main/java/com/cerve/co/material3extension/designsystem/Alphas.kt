package com.cerve.co.material3extension.designsystem

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf

@Immutable
class Alphas(
    val default_0: Float = 0.0f,
    val small_10: Float = 0.1f,
    val medium_30: Float = 0.3f,
    val large_60: Float = 0.6f,
    val full_100: Float = 1f
)

internal val LocalAlphas = staticCompositionLocalOf { Alphas() }
