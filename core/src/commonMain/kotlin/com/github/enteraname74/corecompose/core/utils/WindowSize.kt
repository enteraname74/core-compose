package com.github.enteraname74.corecompose.core.utils

import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalWindowInfo
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

enum class WindowSize(val maxValue: Dp) {
    Small(600.dp),
    Medium(MediumThreshold),
    Large(Dp.Infinity);

    companion object {
        fun getCorrespondingWindowSize(width: Dp): WindowSize =
            when {
                width <= Small.maxValue -> Small
                width <= Medium.maxValue -> Medium
                else -> Large
            }
    }
}

internal val MediumThreshold: Dp = 900.dp

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun rememberWindowSize(): WindowSize {
    val density = LocalDensity.current
    val windowWidth: Dp = with(density) {
        LocalWindowInfo.current.containerSize.width.toDp()
    }

    return WindowSize.Companion.getCorrespondingWindowSize(windowWidth)
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun rememberWindowHeight(): Float = LocalWindowInfo.current.containerSize.height.toFloat()

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun rememberWindowWidth(): Float = LocalWindowInfo.current.containerSize.width.toFloat()


@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun rememberWindowWidthDp(): Dp = with(LocalDensity.current) {
    LocalWindowInfo.current.containerSize.width.toDp()
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun rememberWindowHeightDp(): Dp = with(LocalDensity.current) {
    LocalWindowInfo.current.containerSize.height.toDp()
}