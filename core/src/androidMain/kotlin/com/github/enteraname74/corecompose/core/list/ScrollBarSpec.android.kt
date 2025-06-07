package com.github.enteraname74.corecompose.core.list

import androidx.compose.ui.graphics.Color

actual object ScrollBarDefaults {
    actual fun default(): ScrollBarSpec =
        // TODO: Support for scroll bar on android?
        ScrollBarSpec(
            unhoverColor = Color.Transparent,
            hoverColor = Color.Transparent
        )
}