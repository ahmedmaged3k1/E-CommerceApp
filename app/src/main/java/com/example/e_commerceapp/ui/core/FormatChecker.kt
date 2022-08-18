package com.example.e_commerceapp.ui.core

import android.util.Patterns

class FormatChecker {
    companion object{
        fun isValidEmail(email: String?): Boolean {
            return Patterns.EMAIL_ADDRESS.matcher(email.toString()).matches()
        }

        fun isValidName(phone: String): Boolean {
            return phone.length in 7..15
        }

        fun isValidPassword(year: String): Boolean {
            return year.length == 4
        }
    }
}