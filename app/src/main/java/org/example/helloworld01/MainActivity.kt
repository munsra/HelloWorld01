package org.example.helloworld01

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import org.example.helloworld01.ui.presentation.navigation.Navigation
import org.example.helloworld01.ui.theme.myThemes.HelloWorld01Theme

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HelloWorld01Theme {
                Navigation()
            }
        }
    }
}