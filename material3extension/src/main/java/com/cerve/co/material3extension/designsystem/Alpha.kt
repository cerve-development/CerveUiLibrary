package com.cerve.co.material3extension.designsystem

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf

@Immutable
class Alpha(
    val default: Float = 1f,
    val s_25: Float = 0.25f,
    val m_50: Float = 0.50f,
    val l_75: Float = 0.75f,
    val none: Float = 0f
)

internal val LocalAlphas = staticCompositionLocalOf { Alpha() }
