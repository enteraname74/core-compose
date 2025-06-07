package com.github.enteraname74.corecompose.core.list

import androidx.compose.foundation.HorizontalScrollbar
import androidx.compose.foundation.ScrollbarAdapter
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.github.enteraname74.corecompose.core.ext.toScrollBarStyle

@Composable
actual fun CoreHorizontalScrollBar(
    lazyListState: LazyListState,
    spec: ScrollBarSpec,
    modifier: Modifier
) {
    Column {
        Spacer(
            modifier = Modifier
                .height(SPACER_HEIGHT)
        )
        HorizontalScrollbar(
            modifier = modifier,
            adapter = ScrollbarAdapter(scrollState = lazyListState),
            style = spec.toScrollBarStyle(),
        )
    }
}

private val SPACER_HEIGHT: Dp = 16.dp