
package com.example.emergencyapp

// Import necessary libraries (mocked for simplicity)
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Toast

class EmergencyApp : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Mock setup for UI
        println("Emergency App is running...")
    }

    // Function to validate phone number
    fun validatePhoneNumber(phoneNumber: String): Boolean {
        val regex = Regex("^569[0-9]{8}\$") // Chilean phone numbers
        return regex.matches(phoneNumber)
    }

    // Function to validate password
    fun validatePassword(password: String): Boolean {
        // At least 6 characters, including one digit and one special character
        val regex = Regex("^(?=.*[0-9])(?=.*[!@#\$%^&*])[a-zA-Z0-9!@#\$%^&*]{6,}\$")
        return regex.matches(password)
    }

    // Function to send emergency notification (mocked)
    fun sendEmergencyNotification(phoneNumber: String, emergencyType: String) {
        if (validatePhoneNumber(phoneNumber)) {
            println("Notification sent to $phoneNumber: '$emergencyType emergency in your area. Follow safety protocols!'")
        } else {
            println("Invalid phone number. Notification not sent.")
        }
    }

    // Function to display a mock map with safe routes (placeholder)
    fun displaySafeRoute(emergencyType: String) {
        println("Displaying map for $emergencyType emergency...")
        // Mock route details
        val safeRoutes = when (emergencyType) {
            "Earthquake" -> "Route A -> Main Street -> Safe Zone"
            "Tsunami" -> "Route B -> Coastal Road -> Higher Ground"
            "Fire" -> "Route C -> 2nd Avenue -> Assembly Point"
            else -> "Unknown emergency type. No route available."
        }
        println("Recommended route: $safeRoutes")
    }
}

// Example usage (mocked)
fun main() {
    val app = EmergencyApp()
    val testPhone = "56912345678"
    val testPassword = "Secure@1"

    // Validate user input
    if (app.validatePhoneNumber(testPhone) && app.validatePassword(testPassword)) {
        println("User authenticated successfully.")
        
        // Send emergency notification
        app.sendEmergencyNotification(testPhone, "Earthquake")
        
        // Display safe route
        app.displaySafeRoute("Earthquake")
    } else {
        println("Authentication failed. Check phone number or password.")
    }
}
