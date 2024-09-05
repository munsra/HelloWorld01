package org.example.helloworld01.ui.presentation.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import org.example.helloworld01.ui.presentation.components.Greeting
import org.example.helloworld01.ui.theme.myThemes.HelloWorld01Theme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomePage(
    onNextPage: () -> Unit
){
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
        Box(modifier = Modifier.padding(it)){
            Column {
                Greeting(
                    name = "Android"
                )
                Button(
                    onClick = {
                        onNextPage()
                    },
                ) {
                    Text("Go to Second Screen")
                }
            }
        }
    }
}

@Preview
@Composable
fun HomePagePreview(){
    HelloWorld01Theme {
        HomePage(
            onNextPage = {}
        )
    }
}