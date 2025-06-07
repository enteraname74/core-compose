package com.github.enteraname74.corecompose.core.list

import androidx.compose.foundation.ScrollbarAdapter
import androidx.compose.foundation.VerticalScrollbar
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.github.enteraname74.corecompose.core.ext.toScrollBarStyle

@Composable
actual fun CoreVerticalScrollBar(
    lazyListState: LazyListState,
    spec: ScrollBarSpec,
    modifier: Modifier
) {
    VerticalScrollbar(
        modifier = modifier,
        adapter = ScrollbarAdapter(scrollState = lazyListState),
        style = spec.toScrollBarStyle(),
    )
}