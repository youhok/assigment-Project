package com.example.assigment

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.util.Calendar
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val nameInput = findViewById<EditText>(R.id.nameInput)
        val horoscopeButton = findViewById<Button>(R.id.horoscopeButton)
        val horoscopeText = findViewById<TextView>(R.id.horoscopeText)

        horoscopeButton.setOnClickListener {
            val name = nameInput.text.toString()
            val horoscope = generateHoroscope(name)
            horoscopeText.text = "Hello $name, your horoscope is: $horoscope"
        }
    }

    private fun generateHoroscope(name: String): String {
        val horoscopes = listOf(
            "Today is a great day for new beginnings.",
            "Be wary of the decisions you make today.",
            "Your future is looking bright.",
            "Keep an open mind today, as something unexpected may happen.",
            "Today is a good day to focus on yourself.",
            "You will find peace and happiness in unexpected places.",
            "Challenges may arise, but you have the strength to overcome them.",
            "Someone close to you has good news.",
            "It's a great day to learn something new.",
            "Patience is the key to your success today."
        )

        // Get the current day of the week
        val calendar = Calendar.getInstance()
        val dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK)

        // Combine the hash code of the name and the day of the week for randomness
        val seed = name.hashCode() + dayOfWeek

        // Use a seeded random to ensure reproducibility for the same name and day
        val random = Random(seed)
        return horoscopes[random.nextInt(horoscopes.size)]
    }
}
