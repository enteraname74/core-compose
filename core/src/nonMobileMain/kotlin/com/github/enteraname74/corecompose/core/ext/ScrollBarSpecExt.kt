package com.github.enteraname74.corecompose.core.ext

import androidx.compose.foundation.ScrollbarStyle
import androidx.compose.foundation.defaultScrollbarStyle
import com.github.enteraname74.corecompose.core.list.ScrollBarSpec

fun ScrollBarSpec.toScrollBarStyle(): ScrollbarStyle =
    defaultScrollbarStyle().copy(
        hoverColor = hoverColor,
        unhoverColor = unhoverColor,
    )