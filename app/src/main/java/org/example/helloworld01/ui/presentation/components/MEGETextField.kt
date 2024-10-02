package org.example.helloworld01.ui.presentation.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.sp
import org.example.helloworld01.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MEGETextField(
    value: String,
    onValueChange: ((String) -> Unit)? = null,
    label: String? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
    colors: TextFieldColors = TextFieldDefaults.outlinedTextFieldColors(
        containerColor = Color.White,
        disabledTextColor = Color.Gray,
        disabledLabelColor = Color.LightGray,
        disabledTrailingIconColor = Color.LightGray,
    ),
    textStyle: TextStyle = TextStyle.Default.copy(
        fontSize = 16.sp
    ),
    enabled: Boolean = false,
    isOutlined: Boolean = false,
    readOnly: Boolean = true,
    modifier: Modifier = Modifier.fillMaxWidth()
) {

    if (isOutlined) {
        OutlinedTextField(
            value = value,
            onValueChange = {
                if (onValueChange != null) {
                    onValueChange(it)
                }
            },
            readOnly = readOnly,
            maxLines = 1,
            singleLine = true,
            modifier = modifier,
            label = {
                MEGEText(
                    text = label ?: ""
                )
            },
            textStyle = textStyle,
            trailingIcon = trailingIcon,
            enabled = enabled,
            colors = colors,
        )
    } else {
        TextField(
            value = value,
            onValueChange = {
                if (onValueChange != null) {
                    onValueChange(it)
                }
            },
            readOnly = readOnly,
            maxLines = 1,
            singleLine = true,
            modifier = modifier,
            label = {
                MEGEText(
                    text = label ?: ""
                )
            },
            textStyle = textStyle,
            trailingIcon = trailingIcon,
            enabled = enabled,
            colors = colors,
        )
    }
}