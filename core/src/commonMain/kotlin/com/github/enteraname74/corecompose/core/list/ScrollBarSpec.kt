package com.github.enteraname74.corecompose.core.list

import androidx.compose.foundation.defaultScrollbarStyle
import androidx.compose.ui.graphics.Color

data class ScrollBarSpec(
    val unhoverColor: Color,
    val hoverColor: Color,
)

object ScrollBarDefaults {
    fun default(): ScrollBarSpec =
        with(defaultScrollbarStyle()) {
            ScrollBarSpec(
                unhoverColor = unhoverColor,
                hoverColor = hoverColor,
            )
        }
}
