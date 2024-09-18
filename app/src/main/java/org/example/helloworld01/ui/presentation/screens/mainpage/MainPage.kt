package org.example.helloworld01.ui.presentation.screens.mainpage

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import org.example.helloworld01.ui.theme.myThemes.HelloWorld01Theme

@Composable
fun MainPage(
    viewModel: MainPageViewModel = viewModel()
) {


    Scaffold(
        modifier = Modifier.fillMaxSize()
    ) {
        Row(
            modifier = Modifier.padding(it).fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ){
            // 1 Colonna. Counter + Bottoni increase e decrease
            Column {
                Text(
                    viewModel.counter.toString(),
                    style = TextStyle(
                        fontSize = 36.sp
                    ),
                )
                Row {
                    Button(
                        onClick = {
                            viewModel.inc()
                        }
                    ) {
                        Text("+")
                    }
                    Button(
                        onClick = {
                            viewModel.dec()
                        }
                    ) {
                        Text("-")
                    }
                }
            }

            // Lista Eventi
            Column {
                Text("Lista Events")

                viewModel.events.forEach {
                    Text(it)
                }
            }
        }
    }
}

@Preview
@Composable
fun MainPagePreview() {
    HelloWorld01Theme {
        MainPage()
    }
}