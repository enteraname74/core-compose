package com.github.enteraname74.corecompose.core.feedbackpopupmanager

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class FeedbackPopUpManager {
    private var _state: MutableStateFlow<String?> = MutableStateFlow(null)
    val state: StateFlow<String?> = _state.asStateFlow()

    fun showFeedback(feedback: String) {
        _state.value = feedback
    }

    fun consumeFeedback() {
        _state.value = null
    }
}