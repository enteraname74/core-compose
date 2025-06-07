package com.github.enteraname74.corecompose.core.feedbackpopupmanager

import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.*
import kotlinx.coroutines.launch

@Composable
fun FeedbackPopUpScaffold(
    feedbackPopUpManager: FeedbackPopUpManager,
    content: @Composable () -> Unit
) {

    val coroutineScope = rememberCoroutineScope()
    var isShowingFeedback: Boolean by remember { mutableStateOf(false) }
    val snackbarHostState = remember { SnackbarHostState() }

    val state: String? by feedbackPopUpManager.state.collectAsState()

    state?.let {
        if (isShowingFeedback) return@let
        coroutineScope.launch {
            isShowingFeedback = true
            snackbarHostState.showSnackbar(it)
        }.invokeOnCompletion {
            isShowingFeedback = false
            feedbackPopUpManager.consumeFeedback()
        }
    }

    Scaffold(
        snackbarHost = {
            SnackbarHost(
                hostState = snackbarHostState
            )
        },
    ) {
        content()
    }
}