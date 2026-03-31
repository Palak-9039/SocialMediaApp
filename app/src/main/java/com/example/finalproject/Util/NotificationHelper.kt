package com.example.finalproject.Util

import android.content.Context
import android.util.Log
import com.example.finalproject.BuildConfig
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.json.JSONArray
import org.json.JSONObject
import java.io.DataOutputStream
import java.net.HttpURLConnection
import java.net.URL

class NotificationHelper {
    fun sendNotification(title: String, message: String, playerId: String) {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val json = JSONObject().apply {
                    put("app_id", BuildConfig.ONESIGNAL_APP_ID)
                    put("headings", JSONObject().put("en", title)) // Notification title
                    put("contents", JSONObject().put("en", message)) // Notification message
                }

                val url = URL("https://onesignal.com/api/v1/notifications")
                val connection = url.openConnection() as HttpURLConnection
                connection.requestMethod = "POST"
                connection.doOutput = true
                connection.setRequestProperty("Content-Type", "application/json; charset=UTF-8")
                connection.setRequestProperty("Authorization", "Basic ${BuildConfig.ONESIGNAL_REST_API_KEY}")

                // Send JSON data
                DataOutputStream(connection.outputStream).use { it.writeBytes(json.toString()) }

                val responseCode = connection.responseCode
                val responseMessage = connection.inputStream.bufferedReader().use { it.readText() }

                if (responseCode in 200..299) {
                    Log.d("OneSignal", "Notification sent successfully! Response: $responseMessage")
                } else {
                    Log.e("OneSignal", "Failed to send notification. Response Code: $responseCode, Message: $responseMessage")
                }

                connection.disconnect()
            } catch (e: Exception) {
                Log.e("OneSignal", "Error sending notification", e)
            }
        }
    }

}