package org.example.helloworld01.ui.presentation.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit

@Composable
fun MEGEText(
    text: String,
    fontSize: TextUnit = TextUnit.Unspecified,
    color: Color = Color.Unspecified,
    modifier: Modifier = Modifier
) {
    Text(
        text = text,
        fontSize = fontSize,
        modifier = modifier,
        color = color,
        fontWeight = FontWeight.Bold
    )
}