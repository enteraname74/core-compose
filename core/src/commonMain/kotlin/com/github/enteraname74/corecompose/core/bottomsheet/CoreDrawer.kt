package com.github.enteraname74.corecompose.core.bottomsheet

import androidx.compose.animation.*
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.BottomSheetDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.key.Key
import androidx.compose.ui.input.key.key
import androidx.compose.ui.input.key.onKeyEvent
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.onClick
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.zIndex
import com.github.enteraname74.corecompose.core.CoreComposeUiConstants
import com.github.enteraname74.corecompose.core.ext.disableFocus
import com.github.enteraname74.corecompose.core.utils.rememberWindowWidth
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
internal fun CoreDrawer(
    onClose: () -> Unit,
    spec: CoreAdaptiveBottomSheetSpec,
    content: @Composable (closeWithAnim: () -> Unit) -> Unit,
) {
    var isShown: CoreDrawerState by rememberSaveable {
        mutableStateOf(CoreDrawerState.Init)
    }
    val coroutineScope = rememberCoroutineScope()

    val windowWidth = rememberWindowWidth().toInt()

    LaunchedEffect(Unit) {
        isShown = CoreDrawerState.Open
    }

    val closeWithAnim: () -> Unit = {
        coroutineScope.launch {
            isShown = CoreDrawerState.Closed
            delay(CoreComposeUiConstants.AnimationDuration.normal.toLong())
            onClose()
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .zIndex(1f)
    ) {
        AnimatedVisibility(
            visible = isShown == CoreDrawerState.Open,
            enter = fadeIn(),
            exit = fadeOut(),
        ) {
            Scrim(onClose = closeWithAnim)
        }
        AnimatedVisibility(
            modifier = Modifier.align(Alignment.TopEnd),
            visible = isShown == CoreDrawerState.Open,
            enter = slideInHorizontally(
                initialOffsetX = { windowWidth },
                animationSpec = tween(durationMillis = CoreComposeUiConstants.AnimationDuration.normal)
            ),
            exit = slideOutHorizontally(
                targetOffsetX = { windowWidth },
                animationSpec = tween(durationMillis = CoreComposeUiConstants.AnimationDuration.normal),
            )
        ) {
            Drawer(
                containerColor = spec.colors.containerColor,
            ) {
                content(closeWithAnim)
            }
        }
    }
}

@Composable
private fun Drawer(
    containerColor: Color,
    content: @Composable () -> Unit,
) {
    Box(
        modifier = Modifier
            .disableFocus()
            .fillMaxHeight()
            .fillMaxWidth(.4f)
            .background(color = containerColor),
    ) {
        content()
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun Scrim(
    onClose: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier
            .fillMaxSize()
            // handle pointer input
            .pointerInput(onClose) { detectTapGestures { onClose() } }
            // handle accessibility services
            .semantics(mergeDescendants = true) {
                contentDescription = ""
                onClick {
                    onClose()
                    true
                }
            }
            // handle physical keyboard input
            .onKeyEvent {
                if (it.key == Key.Escape) {
                    onClose()
                    true
                } else {
                    false
                }
            }
            // draw scrim
            .background(BottomSheetDefaults.ScrimColor)
    )
}

private enum class CoreDrawerState {
    Open,
    Closed,
    Init
}