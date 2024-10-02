package org.example.helloworld01.ui.presentation.components

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp

@Composable
fun MEGEDropdownMenu(label: String, items: List<String>, enable: Boolean = true, index: Int = 0, indexSelected: ((Int?) -> Unit)? = null) {

    // tipo ticket
    var indexVariable = remember { mutableStateOf(0) }
    indexVariable.value = index

    CustomDropdownMenu(
        items = items,
        modifier = Modifier.padding(6.dp),
        label = label,
        onItemSelected = {
            if (indexSelected != null) {
                indexSelected(it)
            }
        },
        enabled = enable,
        itemToSelect = indexVariable.value
    )
}