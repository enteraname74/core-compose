package com.github.enteraname74.corecompose.core

import androidx.compose.runtime.ProvidableCompositionLocal
import androidx.compose.runtime.compositionLocalOf
import com.github.enteraname74.corecompose.core.bottomsheet.CoreAdaptiveBottomSheetSpec
import com.github.enteraname74.corecompose.core.list.ScrollBarSpec
import com.github.enteraname74.corecompose.core.loading.LoadingScaffoldColorTheme

val LocalCoreComposeTheme: ProvidableCompositionLocal<CoreComposeTheme?> = compositionLocalOf { null }

data class CoreComposeTheme(
    val scrollBarSpec: ScrollBarSpec,
    val loadingScaffoldColorTheme: LoadingScaffoldColorTheme,
    val bottomSheetSpec: CoreAdaptiveBottomSheetSpec,
)