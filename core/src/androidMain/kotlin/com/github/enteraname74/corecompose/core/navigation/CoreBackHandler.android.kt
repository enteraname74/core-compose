package com.github.enteraname74.corecompose.core.navigation

import androidx.activity.compose.BackHandler
import androidx.compose.runtime.Composable

@Composable
actual fun CoreBackHandler(enabled: Boolean, onBack: () -> Unit) {
    BackHandler(
        enabled = enabled,
        onBack = onBack,
    )
}