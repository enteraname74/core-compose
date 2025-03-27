package com.github.enteraname74.corecompose.core.list

import androidx.compose.foundation.ScrollbarAdapter
import androidx.compose.foundation.VerticalScrollbar
import androidx.compose.foundation.lazy.grid.LazyGridState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.github.enteraname74.corecompose.core.ext.toScrollBarStyle

@Composable
actual fun CoreVerticalGridScrollBar(
    lazyGridState: LazyGridState,
    spec: ScrollBarSpec,
    modifier: Modifier
) {
    VerticalScrollbar(
        modifier = modifier,
        adapter = ScrollbarAdapter(scrollState = lazyGridState),
        style = spec.toScrollBarStyle(),
    )
}