package com.eaproject.yard_sale_fe_mobile

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.eaproject.yard_sale_fe_mobile.core.Username
import com.eaproject.yard_sale_fe_mobile.layout.loginPage

class LoginActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            var viewModel = Username()
            loginPage(viewModel) {
                val intent = Intent(this, HomepageActivity::class.java)
                intent.putExtra("userClass", viewModel.user.value)
                startActivity(intent)
                finish()
            }
        }
    }
}