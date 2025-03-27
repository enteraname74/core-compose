package com.github.enteraname74.corecompose.core.utils

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import kotlinx.coroutines.CoroutineScope

@Composable
fun LaunchInit(
    block: suspend CoroutineScope.() -> Unit,
) {
    var hasBeenInit by rememberSaveable {
        mutableStateOf(false)
    }

    LaunchedEffect(hasBeenInit) {
        if (!hasBeenInit) {
            block()
            hasBeenInit = true
        }
    }
}