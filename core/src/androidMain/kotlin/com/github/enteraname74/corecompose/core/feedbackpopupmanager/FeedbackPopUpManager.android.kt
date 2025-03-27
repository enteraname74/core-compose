package com.github.enteraname74.corecompose.core.feedbackpopupmanager

import android.content.Context
import android.widget.Toast
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

actual class FeedbackPopUpManager(
    private val context: Context,
) {
    actual suspend fun showFeedback(feedback: String) {
        withContext(Dispatchers.Main) {
            Toast.makeText(
                context,
                feedback,
                Toast.LENGTH_SHORT,
            ).show()
        }
    }
}