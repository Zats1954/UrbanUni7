package ru.zatsoft.intent

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import ru.zatsoft.intent.databinding.ActivityCalculatorBinding

class Calculator : AppCompatActivity() {
    //    var intent = Intent()
    var res: Double = 0.0
    lateinit var binding: ActivityCalculatorBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCalculatorBinding.inflate(layoutInflater)
        setSupportActionBar(binding.toolbarMain)
        title = "Скрытый калькулятор"
        setContentView(binding.root)
    }

    fun onButtonClick(view: View) {
        println("onButtonClick")
        val first = binding.etFirstValue.text.toString().toDouble()
        val second = binding.etSecondValue.text.toString().toDouble()

        res = when (view.id) {
            R.id.btnPlus -> {
                Operation(first, second).sum()
            }

            R.id.btnMinus -> {
                Operation(first, second).dif()
            }

            R.id.btnMult -> {
                Operation(first, second).mult()
            }

            R.id.btnDiv -> {
                Operation(first, second).div()
            }

            else -> 0.0
        }
        binding.tvResult.text = res.toString()
        binding.tvResult.setTextColor(Color.parseColor("#8D0000"))
    }

    fun onExitClick(view: View) {
        intent.putExtra("result", res)
        setResult(RESULT_OK, intent)
        finish()
    }
}

class Operation(private val first: Double, private val second: Double) {
    fun sum() = first + second
    fun dif() = first - second
    fun mult() = first * second
    fun div() = first / second
}
