package com.github.enteraname74.corecompose.core.feedbackpopupmanager

import androidx.compose.runtime.Composable

@Composable
expect fun FeedbackPopUpScaffold(
    feedbackPopUpManager: FeedbackPopUpManager,
    content: @Composable () -> Unit
)