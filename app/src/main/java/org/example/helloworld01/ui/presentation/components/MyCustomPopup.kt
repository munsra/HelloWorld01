package org.example.helloworld01.ui.presentation.components

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable


@Composable
fun MyCustomPopup(
    title: String,
    onDismiss: () -> Unit
){
    AlertDialog(
        onDismissRequest = {

        },
        title = {
            Text(text = title)
        },
        text = {
            Text("This is a simple alert dialog.")
        },
        confirmButton = {
            Button(
                onClick = {
                    onDismiss()
                }
            ) {
                Text("OK")
            }
        },
        dismissButton = {
            Button(
                onClick = {

                }
            ) {
                Text("Cancel")
            }
        }
    )
}
