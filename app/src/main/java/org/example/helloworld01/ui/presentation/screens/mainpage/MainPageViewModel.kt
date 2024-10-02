package org.example.helloworld01.ui.presentation.screens.mainpage


import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class MainPageViewModel: ViewModel() {

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

    private val _isCheckboxChecked = mutableStateOf(true)
    val isCheckboxChecked by _isCheckboxChecked

    private val _indexDropdown = mutableStateOf(0)
    var indexDropdown by _indexDropdown

    fun getDropdownStringList() = listOf("Intervento su CE", "Nessun intervento su CE")

    var _isDropdownEnable = mutableStateOf(false)
    var isDropdownEnable by _isDropdownEnable

    var _itemSelected = mutableStateOf("")
    var itemSelected by _itemSelected

    private fun setIsDropdownEnable(enables: Boolean){
        _isDropdownEnable.value = !enables
    }

    fun setCheckboxChecked(isChecked: Boolean) {
        _isCheckboxChecked.value = isChecked

        getDropdownStringList()
        setIsDropdownEnable(isChecked)
    }

    fun setItemSelectedFromDropdownList(index: Int){
        val elements = getDropdownStringList()
        _indexDropdown.value = index
        _itemSelected.value = elements[index]
    }

}