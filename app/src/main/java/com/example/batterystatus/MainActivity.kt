package com.example.batterystatus

import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.batterystatus.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    var batery = ""
    lateinit var getBatteryStatus: GetBatteryStatus

    override fun onCreate(savedInstanceState: Bundle?) {
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        super.onCreate(savedInstanceState)

        getBatteryStatus = GetBatteryStatus(this)

        cambiandoTexto()
    }

    fun cambiandoTexto()
    {
        binding.tvBatteryStatus.setText(batery)
    }
}