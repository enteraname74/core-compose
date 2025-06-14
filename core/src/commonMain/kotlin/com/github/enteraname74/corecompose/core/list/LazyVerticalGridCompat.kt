package com.github.enteraname74.corecompose.core.list

import androidx.compose.foundation.gestures.FlingBehavior
import androidx.compose.foundation.gestures.ScrollableDefaults
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.lazy.grid.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.github.enteraname74.corecompose.core.LocalCoreComposeTheme

@Composable
fun LazyVerticalGridCompat(
    columns: GridCells,
    modifier: Modifier = Modifier,
    state: LazyGridState = rememberLazyGridState(),
    scrollBarSpec: ScrollBarSpec = LocalCoreComposeTheme.current?.scrollBarSpec ?: ScrollBarDefaults.default(),
    contentPadding: PaddingValues = PaddingValues(0.dp),
    reverseLayout: Boolean = false,
    verticalArrangement: Arrangement.Vertical =
        if (!reverseLayout) Arrangement.Top else Arrangement.Bottom,
    horizontalArrangement: Arrangement.Horizontal = Arrangement.Start,
    flingBehavior: FlingBehavior = ScrollableDefaults.flingBehavior(),
    userScrollEnabled: Boolean = true,
    content: LazyGridScope.() -> Unit
) {
    Row {
        LazyVerticalGrid(
            columns = columns,
            modifier = modifier
                .weight(1f),
            state = state,
            contentPadding = contentPadding,
            horizontalArrangement = horizontalArrangement,
            verticalArrangement = verticalArrangement,
            flingBehavior = flingBehavior,
            userScrollEnabled = userScrollEnabled,
        ) {
            content()
        }
        CoreVerticalGridScrollBar(
            lazyGridState = state,
            spec = scrollBarSpec,
        )
    }
}