package com.example.lab1

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.text.isDigitsOnly
import com.example.lab1.databinding.ActivityMainBinding

private lateinit var binding: ActivityMainBinding

class MainActivity : AppCompatActivity() {
    var prevValue: Double? = null
    var curOperation: String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnDot.setOnClickListener{ setContent(".")}
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
        binding.btnDiv.setOnClickListener { calc("div") }
        binding.btnMult.setOnClickListener { calc("mult") }
        binding.btnPlus.setOnClickListener { calc("plus") }
        binding.btnSub.setOnClickListener { calc("minus") }
        binding.btnEqual.setOnClickListener { calc("equals")}
        binding.btnDelete.setOnClickListener{
            if(binding.curVal.text.isNotEmpty()) {
                val text = binding.curVal.text
                binding.curVal.text = text.subSequence(0, text.length - 1)
            }
        }
    }

    private fun setContent(str:String){
        binding.curVal.append(str)
    }

    private fun Double.round(decimals: Int = 2): Double = "%.${decimals}f".format(this).toDouble()

    private fun calc(operation:String){
        if(binding.curVal.text.isEmpty())
            return
        var currentValue = binding.curVal.text.toString().toDouble()
        binding.curVal.text = ""
        if(prevValue == null && curOperation == null && operation != "equals"){
            prevValue = currentValue
            curOperation = operation
        }else{
            var result = when (curOperation) {
                "div" -> (prevValue!! / currentValue).toString()
                "mult" -> (prevValue!! * currentValue).toString()
                "plus" -> (prevValue!! + currentValue).toString()
                "minus" -> (prevValue!! - currentValue).toString()
                else -> ""
            }
            result = when {
                result.length > 1 && result[result.length - 1] == '0' -> result.subSequence(
                    0,
                    result.length - 2
                ) as String
                result != "" -> result.toDouble().round(6).toString()
                else -> ""
            }
            binding.curVal.text = result
            prevValue = null
            curOperation = null
        }
    }
}