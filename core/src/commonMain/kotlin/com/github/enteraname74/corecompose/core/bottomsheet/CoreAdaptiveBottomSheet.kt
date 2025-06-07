package com.github.enteraname74.corecompose.core.bottomsheet

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp
import com.github.enteraname74.corecompose.core.LocalCoreComposeTheme
import com.github.enteraname74.corecompose.core.utils.WindowSize
import com.github.enteraname74.corecompose.core.utils.rememberWindowSize
import kotlinx.coroutines.launch

@Composable
fun CoreAdaptiveBottomSheet(
    onClose: () -> Unit,
    spec: CoreAdaptiveBottomSheetSpec = LocalCoreComposeTheme.current?.bottomSheetSpec
        ?: CoreAdaptiveBottomSheetDefaults.default(),
    content: @Composable (closeWithAnim: () -> Unit) -> Unit,
) {
    val windowSize = rememberWindowSize()

    when (windowSize) {
        WindowSize.Large -> {
            CoreDrawer(
                onClose = onClose,
                spec = spec,
                content = content,
            )
        }

        else -> {
            BottomSheet(
                onClose = onClose,
                spec = spec,
                content = content,
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun BottomSheet(
    onClose: () -> Unit,
    spec: CoreAdaptiveBottomSheetSpec,
    content: @Composable (closeWithAnim: () -> Unit) -> Unit,
) {
    val bottomSheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)
    val coroutineScope = rememberCoroutineScope()

    val closeWithAnim: () -> Unit = {
        coroutineScope.launch {
            bottomSheetState.hide()
        }.invokeOnCompletion {
            onClose()
        }
    }

    ModalBottomSheet(
        onDismissRequest = onClose,
        sheetState = bottomSheetState,
        shape = spec.shape,
        containerColor = spec.colors.containerColor,
        contentColor = spec.colors.contentColor,
        dragHandle = null,
    ) {
        content(closeWithAnim)
    }
}

object CoreAdaptiveBottomSheetDefaults {
    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun colors(): CoreAdaptiveBottomSheetColors = CoreAdaptiveBottomSheetColors(
        containerColor = BottomSheetDefaults.ContainerColor,
        contentColor = contentColorFor(BottomSheetDefaults.ContainerColor),
    )

    private val DEFAULT_BOTTOM_SHEET_SHAPE: Shape = RoundedCornerShape(
        topStart = 14.0.dp,
        topEnd = 14.0.dp,
        bottomEnd = 0.0.dp,
        bottomStart = 0.0.dp
    )

    @Composable
    fun default(): CoreAdaptiveBottomSheetSpec = CoreAdaptiveBottomSheetSpec(
        colors = colors(),
        shape = DEFAULT_BOTTOM_SHEET_SHAPE,
    )
}

data class CoreAdaptiveBottomSheetSpec(
    val colors: CoreAdaptiveBottomSheetColors,
    val shape: Shape,
)

data class CoreAdaptiveBottomSheetColors(
    val containerColor: Color,
    val contentColor: Color,
)