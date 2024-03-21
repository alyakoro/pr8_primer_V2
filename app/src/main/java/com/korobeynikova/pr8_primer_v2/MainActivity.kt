package com.korobeynikova.pr8_primer_v2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.korobeynikova.pr8_primer_v2.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var right = 0
    private var lose = 0
    private var all = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.loseButton.isEnabled = false
        binding.reightButton.isEnabled = false

        binding.startButton.setOnClickListener {
            button()

            generatePrimer()
        }
    }

    private fun button() {
        binding.loseButton.isEnabled = true
        binding.reightButton.isEnabled = true
        binding.startButton.isEnabled = false
    }

    private fun generatePrimer(){

        val numberOne = Random.nextInt(10, 100)
        val numberTwo = Random.nextInt(10, 100)
        val operators = arrayOf('+', '-', '*', '/')

        val operator = operators.random()

        binding.nullNull1.text = numberOne.toString()
        binding.nullNull2.text = numberTwo.toString()
        binding.znak.text = operator.toString()

        val isCorrect = Random.nextBoolean()

        val correctResult = when (operator) {
            '+' -> numberOne + numberTwo
            '-' -> numberOne - numberTwo
            '*' -> numberOne * numberTwo
            '/' -> {
                val result = numberOne.toDouble() / numberTwo.toDouble()
                String.format("%.2f", result).toDouble()
            }
            else -> throw IllegalArgumentException("Unknown operator")
        }
        if (isCorrect) {
            binding.vvvod.text = correctResult.toString()
        } else {
            var wrongResult: Number
            do {
                val randomNumberString = String.format("%.2f", Random.nextDouble(0.1, 10.0)).replace(',', '.')
                wrongResult = when (operator) {
                    '/' -> randomNumberString.toDouble()
                    else -> Random.nextInt(5, 200)
                }
            } while (wrongResult == correctResult)
            binding.vvvod.text = wrongResult.toString()
        }

        proverPrimer(binding.vvvod.text.toString().toDouble(),
            correctResult.toDouble())
    }

    private fun proverPrimer(result: Double, correct: Double) {
        //time

        binding.loseButton.setOnClickListener {
            if (result != correct)
                right++
            else
                lose++
            all++
            generatePrimer()
            voodoo()
        }
        binding.reightButton.setOnClickListener {
            if (result == correct)
                right++
            else
                lose++
            all++
            generatePrimer()
            voodoo()
        }
    }

    private fun voodoo(){
        binding.itogoNull.text = all.toString()
        binding.rightNull.text = right.toString()
        binding.loseNull.text = lose.toString()

        val present = String.format("%.2f%%", (right.toDouble() / all.toDouble()) * 100)
        binding.prosenttext.text = present
    }
}