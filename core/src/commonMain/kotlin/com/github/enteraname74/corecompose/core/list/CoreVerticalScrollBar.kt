package com.github.enteraname74.corecompose.core.list

import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
internal expect fun CoreVerticalScrollBar(
    lazyListState: LazyListState,
    spec: ScrollBarSpec,
    modifier: Modifier = Modifier,
)