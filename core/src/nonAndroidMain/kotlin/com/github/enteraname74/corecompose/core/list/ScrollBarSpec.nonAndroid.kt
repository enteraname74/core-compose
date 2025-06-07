package com.github.enteraname74.corecompose.core.list

import androidx.compose.foundation.defaultScrollbarStyle

actual object ScrollBarDefaults {
    actual fun default(): ScrollBarSpec =
        with(defaultScrollbarStyle()) {
            ScrollBarSpec(
                unhoverColor = unhoverColor,
                hoverColor = hoverColor,
            )
        }
}