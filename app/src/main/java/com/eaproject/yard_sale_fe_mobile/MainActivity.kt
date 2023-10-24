package com.eaproject.yard_sale_fe_mobile

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
//                    var viewModel = Username()
                    var viewModel by remember { mutableStateOf(Username()) }
                    var state by remember { mutableStateOf(true) }
                    if (state) {
                        compOne(viewModel) { state = false }
                    } else {
                        compTwo(viewModel) { state = true }
                    }

//                    loginPage(viewModel)
//                    homePage(viewModel)
                }
            }
        }
    }
}

class Username : ViewModel() {
    private val userInput = MutableStateFlow("")
    val user: StateFlow<String> = userInput

    fun updateText(text: String) {
        userInput.value = text
        Log.d("ViewModel", "Nuovo valore di userInput: ${userInput.value}")
    }

    fun getText(): String {
        return userInput.value
    }
}

@Composable
fun compOne(viewModel: Username, onContentChange: () -> Unit){
    Log.d("compOne", "Carico compOne")
    var textArea by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LazyColumn {
            item {
                TextField(
                    value = textArea,
                    onValueChange = { newTesto -> textArea = newTesto },
                    modifier = Modifier
                        .background(Color.White, CircleShape)
                )
                Button(
                    onClick = {
                        viewModel.updateText(textArea)
                        Log.d("UpdateTest", "updateText() eseguita con testo: $textArea")
//                        CoroutineScope(Dispatchers.Default).launch {
//                            delay(5000)
//                            onContentChange()
//                        }
                        onContentChange()
                    },
                    modifier = Modifier
                        .background(Color.Yellow)
                        .fillMaxSize()
                        .padding(50.dp)

                ) {
                    Text(
                        "vai a pagina 2",
                        style = TextStyle(
                            fontSize = 20.sp,
                            color = Color.Red,
                            textAlign = TextAlign.Center,
                            background = Color.Black
                        )
                    ) }
                }
            }
    }
}

@Composable
fun compTwo(viewModel: Username, onContentChange: () -> Unit){
    Log.d("compTwo", "Carico compTwo")
    Log.d("Composable", "Homepage: userInput = ${viewModel.user.collectAsState().value}")
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LazyColumn{item {
            Text("Messaggio: ${viewModel.user.collectAsState().value}")
            Button(
                onClick = onContentChange
            ) {
                Text("vai a pagina 1")
            }
        }}
    }
}
/*********************************************************************************/

@Composable
fun loginPage(viewModel: Username) {
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
fun homePage(viewModel: Username) {
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

//new Studente("noem", "cognome")
//new Studente("noem1", "cognome2")
//new Studente("noem1", "cognome3")
//        L oggetto studente è stateless
//
//class Studente() {
//    nome = pippo
//}

