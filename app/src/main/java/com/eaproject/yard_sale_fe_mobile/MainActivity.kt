package com.eaproject.yard_sale_fe_mobile

import android.os.Bundle
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
import kotlinx.coroutines.flow.*

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
                    Greeting()
//                    var clickCount by remember { mutableStateOf(0)}
//                    ClickCounter(clicks = clickCount, onClick = {
//                        clickCount += 1
//                    })

                }
            }
        }
    }
}

//@Composable
//fun Greeting(name: String) {
//    Text(text = "Hello $name!")
//}
//
//@Preview(showBackground = true)
//@Composable
//fun DefaultPreview() {
//    Yard_Sale_FE_MobileTheme {
//        Greeting("Android")
//    }
//}

@Composable
fun ClickCounter(clicks: Int, onClick: () -> Unit) {
    Column() {
        Button(onClick = onClick) {
            Text(text = "Number of clicks: $clicks")
        }
    }
}


//@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextFieldExample() {
//    var myContent by remember { mutableStateOf("") }
     var (myContent, setValue) = remember { mutableStateOf("") }
//    setValue("ciao")
    Column {
        TextField(
            value = myContent,
            onValueChange = { content -> myContent = content },
            // onValueChange = { setValue(it) },
            label = { Text("") },
            placeholder = { Text(text = "Your content") }
        )
    }
}

//@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Greeting(user: UserViewModel) {
    var userFirstName by remember { mutableStateOf("") }
    var updated = 1
    var obs by remember { mutableStateOf(user.immutableUser)}

    user._user.value.firstName = "pippo"
    user.userVariable.value.firstName = "pippo"

    user.immutableUser.firstName = "nuovo nome" //NON AGGIORNA L'OSSERVABILE (e quindi non lancia evento e ricomposizione)
    obs.firstName = "nuovo nome" //NON AGGIORNA L'OGGETTO ORIGINALE (lancia evento e ricomposizione ma solo dell'osservabile)
    Column {
        Text(
            text = "Hello ${user._user.collectAsState().value.firstName}!",
        )
        TextField(
            value = userFirstName,
            onValueChange = { content -> userFirstName = content },
            placeholder = { Text(text = "First Name") }
        )
        Button(
            onClick = {
                user.updateFirstName(userFirstName)
                updated += 1
                obs = userFirstName
                      },
        ) {
            Text(text = "Update")
        }
    }
}

fun Pippo() {
    var user : UserViewModel = "stesso oggetto di prima"

    var obs2 by remember { mutableStateOf(user.immutableUser)}

    obs2 //NON LANCERA' NESSUN EVENTO SE IMMUTABLEUSER O OBS VIENE AGGIORNATO DA UN'ALTRA PARTE
}

data class UserState (
    var username: String = "",
    var firstName: String = "",
    var lastName: String = "",
)

class UserViewModel : ViewModel() {

    val _user = MutableStateFlow(UserState(firstName = "Mario", lastName = "Rossi", username = "supermario"))
    val userVariable: StateFlow<UserState> = _user.asStateFlow()

    val immutableUser = UserState(firstName = "Mario", lastName = "Rossi", username = "supermario")

    fun updateFirstName(firstName: String) {
        _user.update { current -> current.copy(
            username = current.username,
            firstName = firstName,
            lastName = current.lastName) }
    }
}
