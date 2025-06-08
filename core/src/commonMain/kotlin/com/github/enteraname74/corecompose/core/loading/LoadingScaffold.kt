package com.github.enteraname74.corecompose.core.loading

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.BottomSheetDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ProgressIndicatorDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.github.enteraname74.corecompose.core.CoreComposeUiConstants
import com.github.enteraname74.corecompose.core.LocalCoreComposeTheme
import com.github.enteraname74.corecompose.core.ext.disableFocus

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoadingScaffold(
    loadingManager: LoadingManager,
    spec: LoadingScaffoldColorTheme = LocalCoreComposeTheme.current?.loadingScaffoldColorTheme
        ?: LoadingScaffoldDefault.colors(),
    animationDurationMillis: Int = CoreComposeUiConstants.AnimationDuration.short,
    content: @Composable (isLoading: Boolean) -> Unit,
) {
    val state: Boolean by loadingManager.state.collectAsState()

    Box(
        modifier = Modifier
            .fillMaxSize(),
    ) {
        content(state)
        AnimatedVisibility(
            visible = state,
            enter = fadeIn(
                animationSpec = tween(
                    durationMillis = animationDurationMillis,
                )
            ),
            exit = fadeOut(
                animationSpec = tween(
                    durationMillis = animationDurationMillis,
                )
            ),
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(spec.containerColor.copy(alpha = BottomSheetDefaults.ScrimColor.alpha))
                    .disableFocus(),
                contentAlignment = Alignment.Center,
            ) {
                CircularProgressIndicator(
                    color = spec.progressColor,
                )
            }
        }
    }
}


data class LoadingScaffoldColorTheme(
    val containerColor: Color,
    val progressColor: Color,
)

object LoadingScaffoldDefault {
    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun colors() =
        LoadingScaffoldColorTheme(
            containerColor = BottomSheetDefaults.ScrimColor,
            progressColor = ProgressIndicatorDefaults.circularColor,
        )
}