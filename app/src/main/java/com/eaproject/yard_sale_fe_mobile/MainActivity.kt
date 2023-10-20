package com.eaproject.yard_sale_fe_mobile

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModel
import com.eaproject.yard_sale_fe_mobile.ui.theme.Yard_Sale_FE_MobileTheme
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Yard_Sale_FE_MobileTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val viewModel = username()
                    loginPage(viewModel)
                    homePage(viewModel)
                    this.application

//                    Greeting()
                }
            }
        }
    }
}


class username : ViewModel() {
    val userInput = MutableStateFlow("")
    val user: StateFlow<String> = userInput
    fun updateText(text: String) {
        userInput.value = text
        Log.d("ViewModel", "Nuovo valore di userInput: ${userInput.value}")
    }
}

@Composable
fun loginPage(viewModel: username) {
        var testo by remember { mutableStateOf("") }
    Log.d("Composable", "Carico loginpage")

        Column {
            TextField(
                value = testo,
                onValueChange = { newTesto -> testo = newTesto},
            )

            Button(
                onClick = {
                    viewModel.updateText(testo)
                }
            ) {
                Text("Premi")
            }

        }
}

@Composable
fun homePage(viewModel: username) {
    Log.d("Composable", "Homepage: userInput = ${viewModel.user.collectAsState().value}")
    val receivedText = viewModel.user.collectAsState().value
    Text("Ciao: ${viewModel.user.collectAsState().value}")
}

@Composable
fun Greeting() {
    var userFirstName by remember { mutableStateOf("") }
    var updated by remember { mutableStateOf(1)}
    var obs by remember { mutableStateOf(" obs")}
    Column {
        Text(
            text = "Hello ${updated} ${obs}!",
        )
        TextField(
            value = userFirstName,
            onValueChange = { content -> userFirstName = content },
            placeholder = { Text(text = "First Name") }
        )
        Button(
            onClick = {
                updated += 1
                obs = userFirstName
                      },
        ) {
            Text(text = "Update")
        }
    }
}
