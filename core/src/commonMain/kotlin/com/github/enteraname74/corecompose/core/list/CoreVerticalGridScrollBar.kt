package com.github.enteraname74.corecompose.core.list

import androidx.compose.foundation.lazy.grid.LazyGridState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
internal expect fun CoreVerticalGridScrollBar(
    lazyGridState: LazyGridState,
    spec: ScrollBarSpec,
    modifier: Modifier = Modifier,
)