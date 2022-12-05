package com.cerve.co.material3extension.designsystem

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Immutable
class Spaces(
    val default: Dp = 0.dp,
    val small: Dp = 8.dp,
    val medium: Dp = 16.dp,
    val large: Dp = 32.dp
)

internal val LocalSpaces = staticCompositionLocalOf { Spaces() }
