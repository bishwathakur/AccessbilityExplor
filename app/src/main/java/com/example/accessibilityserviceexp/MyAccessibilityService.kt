package com.example.accessibilityserviceexp

import android.accessibilityservice.AccessibilityService
import android.util.Log
import android.view.accessibility.AccessibilityEvent

class MyAccessibilityService : AccessibilityService() {

    override fun onAccessibilityEvent(event: AccessibilityEvent?) {
        event?.let {
            if (event.eventType == AccessibilityEvent.TYPE_WINDOW_STATE_CHANGED) {
                val packageName = event.packageName.toString()
                Log.d("AccessibilityService", "Current package: $packageName")

                // Check for specific apps
                if (packageName.contains("instagram") || packageName.contains("youtube") || packageName.contains("snapchat")) {
                    Log.d("AccessibilityService", "Short video detected in: $packageName")
                }
            }
        }
    }

    override fun onInterrupt() {
        // Handle interruptions
    }
}
