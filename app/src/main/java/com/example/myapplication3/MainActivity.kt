package com.example.myapplication3

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.linear_demo)

        val inputField = findViewById<EditText>(R.id.input_text)
        val textView = findViewById<TextView>(R.id.text_view)
        val button = findViewById<Button>(R.id.button)

        button.setOnClickListener {
            val inputText = inputField.text.toString().toIntOrNull()
            if (inputText != null && inputText >= 1 && inputText <= 1000) {
                val textNum = numToText(inputText)
                textView.text = textNum
            } else {
                textView.text = "Please enter a number between 1 and 1000"
            }
        }
    }

    private fun numToText(num: Int): String {
        val ones = arrayOf("", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine")
        val teens = arrayOf("ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen")
        val tens = arrayOf("", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety")
        val hundreds = arrayOf("", "one hundred", "two hundred", "three hundred", "four hundred", "five hundred", "six hundred", "seven hundred", "eight hundred", "nine hundred")

        if (num == 1000) {
            return "one thousand"
        }
        if (num >= 100) {
            val h = num / 100
            val remainder = num % 100
            val hundredPart = hundreds[h]
            val remainderPart = if (remainder > 0) " " + numToText(remainder) else ""
            return hundredPart + remainderPart
        }
        if (num >= 20) {
            val t = num / 10
            val remainder = num % 10
            val tenPart = tens[t]
            val unitPart = if (remainder > 0) ones[remainder] else ""
            return tenPart + unitPart
        }
        if (num >= 10) {
            return teens[num - 10]
        }
        return ones[num]
    }
}


