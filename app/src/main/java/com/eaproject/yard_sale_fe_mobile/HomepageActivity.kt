package com.eaproject.yard_sale_fe_mobile

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.collectAsState
import com.eaproject.yard_sale_fe_mobile.core.Username
import com.eaproject.yard_sale_fe_mobile.layout.homePage

class HomepageActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val user = intent.getStringExtra("userClass")
            Log.d("Activity", "Homepage: userInput = ${user}")
            if (user != null) {
                homePage(user) {
                    val intent = Intent(this, LoginActivity::class.java)
                    startActivity(intent)
                    finish()
                }
            }
        }
    }
}