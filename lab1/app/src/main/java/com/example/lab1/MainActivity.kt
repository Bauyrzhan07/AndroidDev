package com.example.lab1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.lab1.databinding.ActivityMainBinding

private lateinit var binding: ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        binding.btn0.setOnClickListener { setContent("0") }
        binding.btn1.setOnClickListener { setContent("1") }
        binding.btn2.setOnClickListener { setContent("2") }
        binding.btn3.setOnClickListener { setContent("3") }
        binding.btn4.setOnClickListener { setContent("4") }
        binding.btn5.setOnClickListener { setContent("5") }
        binding.btn6.setOnClickListener { setContent("6") }
        binding.btn7.setOnClickListener { setContent("7") }
        binding.btn8.setOnClickListener { setContent("8") }
        binding.btn9.setOnClickListener { setContent("9") }
        binding.btnDiv.setOnClickListener { setContent("÷") }
        binding.btnMult.setOnClickListener { setContent("×") }
        binding.btnPlus.setOnClickListener { setContent("+") }
        binding.btnSub.setOnClickListener { setContent("-") }
    }

    fun setContent(str:String){
        binding.operation.append(str)
    }
}