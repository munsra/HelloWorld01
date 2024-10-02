package org.example.helloworld01.ui.presentation.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.toSize


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomDropdownMenu(
    items: List<String>,
    modifier: Modifier = Modifier,
    label: String? = "",
    enabled: Boolean = true,
    expandable: Boolean = true,
    itemToSelect: Int? = null,
    isNullable: Boolean = false,
    onItemSelected: ((Int) -> Unit)? = null,
) {
    val contextForToast = LocalContext.current.applicationContext
    val emptyString = "Empty String"
    var mList = mutableListOf<String>()
    if (isNullable) mList.add(emptyString)
    mList.addAll(items)
    val isItemSelected = remember {
        mutableStateOf(false)
    }
    var selectedItem by remember {
        mutableStateOf(emptyString)
    }
    // mi server per capire che indice è stato selezionato
    var selectedItemIndex by remember {
        mutableStateOf(mList.indexOf(selectedItem))
    }

    var mTextFieldSize by remember { mutableStateOf(Size.Zero) }

    if (itemToSelect != null && itemToSelect >= 0 && itemToSelect < mList.size) {
        selectedItem = mList[itemToSelect]
    }

    if (itemToSelect == -1) {
        selectedItem = emptyString
    }

    var expanded by remember {
        mutableStateOf(false)
    }

    // Up Icon when expanded and down icon when collapsed
    val icon = if (expanded)
        Icons.Filled.KeyboardArrowUp
    else
        Icons.Filled.KeyboardArrowDown

    if(mList == null || mList.size == 0){
        MEGETextField(
            value = "-",
            onValueChange = {},
            label = label,
            trailingIcon = {
                ExposedDropdownMenuDefaults.TrailingIcon(
                    expanded = false
                )
            },
            colors = if (enabled) getDefaultDropdownMenuTextColor(isItemSelected.value) else getDefaultDiablesDropdownMenuTextColor(
                isItemSelected.value
            ),
            modifier = modifier
                .fillMaxWidth()
                .onGloballyPositioned { coordinates ->
                    // This value is used to assign to
                    // the DropDown the same width
                    mTextFieldSize = coordinates.size.toSize()
                },
        )
    } else {
        ExposedDropdownMenuBox(expanded = expanded, onExpandedChange = {
            if (enabled) {
                expanded = !expanded
            }
        }) {
            MEGETextField(
                value = selectedItem,
                onValueChange = {},
                label = label,
                trailingIcon = {
                    ExposedDropdownMenuDefaults.TrailingIcon(
                        expanded = if (!expandable) {
                            false
                        } else {
                            expanded
                        }
                    )
                },
                colors = if (enabled) getDefaultDropdownMenuTextColor(isItemSelected.value) else getDefaultDiablesDropdownMenuTextColor(
                    isItemSelected.value
                ),
                modifier = modifier
                    .fillMaxWidth()
                    .onGloballyPositioned { coordinates ->
                        // This value is used to assign to
                        // the DropDown the same width
                        mTextFieldSize = coordinates.size.toSize()
                    },
            )

            // menu
            DropdownMenu(
                expanded = if (!expandable) {
                    false
                } else {
                    expanded
                },
                onDismissRequest = { expanded = false },
                modifier = Modifier
                    .width(with(LocalDensity.current) { mTextFieldSize.width.toDp() })
            ) {
                mList.forEach { selectedOption ->
                    // menu item
                    DropdownMenuItem(
                        text = {
                            Text(
                                text = selectedOption,
                                fontStyle = if (selectedOption == emptyString) FontStyle.Italic else FontStyle.Normal,
                            )
                        },
                        onClick = {
                        selectedItem = selectedOption
                        selectedItemIndex = mList.indexOf(selectedOption)
                        expanded = false
                        if (isNullable) {
                            onItemSelected!!(selectedItemIndex - 1)
                            isItemSelected.value = selectedItemIndex > 0
                        } else {
                            onItemSelected!!(selectedItemIndex)
                            isItemSelected.value = true
                        }
                    })
                }
            }
        }
    }


}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun getDefaultDropdownMenuTextColor(isItemSelected: Boolean): TextFieldColors {
    return TextFieldDefaults.outlinedTextFieldColors(
        containerColor = Color.LightGray,
        disabledTextColor = Color.Black,
        unfocusedLabelColor = Color.Black,
        disabledLabelColor = Color.Black,
        disabledTrailingIconColor = Color.Black,
        focusedBorderColor = if (isItemSelected) Color.Black else Color.LightGray,
        unfocusedBorderColor = if (isItemSelected) Color.Black else Color.LightGray,
        disabledBorderColor = if (isItemSelected) Color.Black else Color.LightGray,
        errorBorderColor = if (isItemSelected) Color.Black else Color.LightGray,
    )
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun getDefaultDiablesDropdownMenuTextColor(isItemSelected: Boolean): TextFieldColors {
    return ExposedDropdownMenuDefaults.outlinedTextFieldColors(
        focusedBorderColor = if (isItemSelected) Color.Black else Color.LightGray,
        unfocusedBorderColor = if (isItemSelected) Color.Black else Color.LightGray,
        disabledBorderColor = if (isItemSelected) Color.Black else Color.LightGray,
        errorBorderColor = if (isItemSelected) Color.Black else Color.LightGray,
    )
}