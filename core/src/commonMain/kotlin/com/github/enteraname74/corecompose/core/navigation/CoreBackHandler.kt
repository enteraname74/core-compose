package com.github.enteraname74.corecompose.core.navigation

import androidx.compose.runtime.Composable

@Composable
expect fun CoreBackHandler(
    enabled: Boolean = true,
    onBack: () -> Unit
)