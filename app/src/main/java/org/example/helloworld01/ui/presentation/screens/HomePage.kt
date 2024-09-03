package org.example.helloworld01.ui.presentation.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import org.example.helloworld01.ui.presentation.components.Greeting
import org.example.helloworld01.ui.theme.myThemes.HelloWorld01Theme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomePage(){
    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                ),
                title = {
                    Text("Hello World")
                }
            )
        },
        modifier = Modifier.fillMaxSize(),
    ) {
        Greeting(
            modifier = Modifier.padding(it),
            name = "Android"
        )
    }
}

@Preview
@Composable
fun HomePagePreview(){
    HelloWorld01Theme {
        HomePage()
    }
}