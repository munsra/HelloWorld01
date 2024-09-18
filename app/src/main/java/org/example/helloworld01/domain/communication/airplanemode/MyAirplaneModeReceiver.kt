package org.example.helloworld01.domain.communication.airplanemode

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent

class MyAirplaneModeReceiver : BroadcastReceiver() {

    interface IAirPlaneModeCustom {
        fun sendAirplaneMode(mode: Boolean)
    }

    fun registerAirPlaneModeCustom(iAirPlaneModeCustom: IAirPlaneModeCustom){
        this.iAirPlaneModeCustom = iAirPlaneModeCustom
    }

    private var iAirPlaneModeCustom: IAirPlaneModeCustom? = null

    override fun onReceive(ctx: Context?, intent: Intent?) {
        if(iAirPlaneModeCustom != null){
            iAirPlaneModeCustom!!.sendAirplaneMode(true)
        }
    }

}