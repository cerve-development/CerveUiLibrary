package com.cerve.co.material3extension.designsystem

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Immutable
class Size(
    val default: Dp = 0.dp,
    val xSmall: Dp = 2.dp,
    val small: Dp = 8.dp,
    val medium: Dp = 16.dp,
    val large: Dp = 32.dp,
    val xLarge: Dp = 64.dp
)

internal val LocalSizes = staticCompositionLocalOf { Size() }
