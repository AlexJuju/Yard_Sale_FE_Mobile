package com.eaproject.yard_sale_fe_mobile.core

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class Username : ViewModel() {
    private val userInput = MutableStateFlow("")
    val user: StateFlow<String> = userInput

    fun updateText(text: String) {
        userInput.value = text
    }
}