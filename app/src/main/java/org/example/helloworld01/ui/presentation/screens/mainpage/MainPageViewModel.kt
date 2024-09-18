package org.example.helloworld01.ui.presentation.screens.mainpage


import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class MainPageViewModel: ViewModel() {

    //var counter by remember { mutableStateOf(0) }

    var events = mutableStateListOf<String>()

    var counter by mutableStateOf(0)
        private set

    fun inc(){
        counter++
        events.add("Inc: ${counter}")
    }

    fun dec(){
        counter--
        events.add("Dec: ${counter}")
    }

}