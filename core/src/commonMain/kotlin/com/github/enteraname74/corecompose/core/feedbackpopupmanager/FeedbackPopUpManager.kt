package com.github.enteraname74.corecompose.core.feedbackpopupmanager

expect class FeedbackPopUpManager {
    /**
     * Shows a feedback notification to the user.
     */
    suspend fun showFeedback(feedback: String)
}