package com.eaproject.yard_sale_fe_mobile.core

import android.os.Parcel
import android.os.Parcelable
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import java.io.Serializable

//https://stackoverflow.com/questions/47593205/how-to-pass-custom-object-via-intent-in-kotlin
//https://developer.android.com/reference/kotlin/android/content/Intent
class Username() : ViewModel(){
    /*------------------------------------------------------------*/
    private val userInput = MutableStateFlow("")
    val user: StateFlow<String> = userInput

    fun updateText(text: String) {
        userInput.value = text
    }
}