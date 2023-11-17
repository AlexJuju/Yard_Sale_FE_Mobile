package com.eaproject.yard_sale_fe_mobile

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.ui.Modifier
import com.eaproject.yard_sale_fe_mobile.ui.theme.Yard_Sale_FE_MobileTheme

import androidx.navigation.compose.rememberNavController
import com.eaproject.yard_sale_fe_mobile.controller.navigationTest
import com.eaproject.yard_sale_fe_mobile.core.Username

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Yard_Sale_FE_MobileTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
//                    var viewModel = Username()
                    val intent = Intent(this, LoginActivity::class.java)
                    startActivity(intent)
                    finish()
//                    var navController = rememberNavController()
//                    navigationTest(navController, viewModel)
                }
            }
        }
    }
}

