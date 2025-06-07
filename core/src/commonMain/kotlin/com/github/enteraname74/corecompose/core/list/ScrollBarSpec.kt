package com.github.enteraname74.corecompose.core.list

import androidx.compose.ui.graphics.Color

data class ScrollBarSpec(
    val unhoverColor: Color,
    val hoverColor: Color,
)

expect object ScrollBarDefaults {
    fun default(): ScrollBarSpec
}
