package com.example.batterystatus

import android.content.Intent
import android.content.IntentFilter
import android.os.BatteryManager
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlin.math.min

open class GetBatteryStatus (activity: AppCompatActivity){

    var context : AppCompatActivity = activity


    open fun Battery(): Float?
    {
        val batteryStatus: Intent? = IntentFilter(Intent.ACTION_BATTERY_CHANGED).let { ifilter ->
            context.registerReceiver(null, ifilter)
        }


        val batteryPct: Float? = batteryStatus?.let { intent ->
            val level: Int = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, -1)
            val scale: Int = intent.getIntExtra(BatteryManager.EXTRA_SCALE, -1)
            level * 100 / scale.toFloat()
        }

        //println("$batteryPct -------------------->>")
        //Log.d("status", "BatteryStatus: $batteryPct")

        if (context is MainActivity)
        {
            var mA = (context as MainActivity)
            mA.batery = batteryPct.toString()
        }
        return batteryPct
    }


    /*public fun status(minimo: Float): Boolean{
        var bateria = Battery()
        var status = bateria!! > minimo
        if (context is MainActivity)
        {
            var mA = (context as MainActivity)
            mA.batery = status.toString()
        }
        return  bateria!! > minimo
    }*/

}