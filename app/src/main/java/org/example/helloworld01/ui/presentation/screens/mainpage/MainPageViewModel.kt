package org.example.helloworld01.ui.presentation.screens.mainpage


import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class MainPageViewModel: ViewModel() {

    //var counter by remember { mutableStateOf(0) }

    var counter by mutableStateOf(0)
        private set

    fun inc(){
        counter++
    }

    fun dec(){
        counter--
    }

}