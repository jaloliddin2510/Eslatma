package com.example.eslatma

import android.app.Dialog
import android.os.Bundle
import android.os.PersistableBundle
import android.view.Window
import androidx.appcompat.app.AppCompatActivity
import com.example.eslatma.databinding.ActivityMainBinding
import com.example.eslatma.databinding.AddFragmentBinding
import com.example.eslatma.databinding.PinFragmentBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding1: PinFragmentBinding
    private var code = 1234
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding1 = PinFragmentBinding.inflate(layoutInflater)
    }


}