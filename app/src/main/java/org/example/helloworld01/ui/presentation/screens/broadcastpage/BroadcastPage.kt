package org.example.helloworld01.ui.presentation.screens.broadcastpage

import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import org.example.helloworld01.domain.communication.airplanemode.MyAirplaneModeReceiver
import org.example.helloworld01.ui.theme.myThemes.HelloWorld01Theme

@Composable
fun BroadcastPage(
    onNextPage: () -> Unit
){

    Scaffold {

        var startBroadcastReceiver by remember { mutableStateOf(false)  }
        var broadcastStatus by remember { mutableStateOf("Broadcast receiver non attivo") }
        Column(
            modifier = Modifier.padding(it).fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(broadcastStatus)
            Button(
                onClick = {
                    startBroadcastReceiver = true
                    broadcastStatus = "Broadcast Receiver Partito"
                }
            ) {
                Text("Start broadcast receiver")
            }

            Button(
                onClick = {
                    startBroadcastReceiver = false
                    broadcastStatus = "Broadcast Receiver Cancellato"
                }
            ) {
                Text("End broadcast receiver")
            }

            Button(
                onClick = {
                    onNextPage()
                }
            ) {
                Text("Torna su HOME PAGE")
            }

            if(startBroadcastReceiver){
                BroadcastManager()
            }
        }
    }
}

@Composable
fun BroadcastManager(){
    val context = LocalContext.current
    DisposableEffect(context) {
        val receiver = setRecevier(context)
        onDispose {
            context.unregisterReceiver(receiver)
        }
    }
}

private fun setRecevier(context: Context): MyAirplaneModeReceiver{
    val intentFilter = IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED)
    val airplaneModeReceiver = MyAirplaneModeReceiver()

    val iAirPlaneModeCustom: MyAirplaneModeReceiver.IAirPlaneModeCustom =
        object : MyAirplaneModeReceiver.IAirPlaneModeCustom {
            override fun sendAirplaneMode(mode: Boolean) {
                Log.d("RECEIVER", "SEND AIRPLANE MODE")
            }
        }

    airplaneModeReceiver.registerAirPlaneModeCustom(iAirPlaneModeCustom)

    context.registerReceiver(
        airplaneModeReceiver,
        intentFilter
    )
    return airplaneModeReceiver
}

@Preview
@Composable
fun BroadcastPagePreview() {
    HelloWorld01Theme {
        BroadcastPage(
            onNextPage = {}
        )
    }
}