package com.eaproject.yard_sale_fe_mobile.layout

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.eaproject.yard_sale_fe_mobile.core.Username

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