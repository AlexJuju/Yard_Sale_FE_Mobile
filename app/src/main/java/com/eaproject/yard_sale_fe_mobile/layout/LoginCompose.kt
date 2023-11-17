package com.eaproject.yard_sale_fe_mobile.layout

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.eaproject.yard_sale_fe_mobile.core.Username

@Composable
fun loginPage(viewModel: Username, onContentChange: () -> Unit){
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
                        .background(Color.White, CircleShape),
                    textStyle = TextStyle(color = Color.Black, fontSize = 16.sp)
                )
                Button(
                    onClick = {
                        viewModel.updateText(textArea)
                        Log.d("UpdateTest", "updateText() eseguita con testo: $textArea")
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