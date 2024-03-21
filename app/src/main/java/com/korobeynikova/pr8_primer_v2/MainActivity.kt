package com.korobeynikova.pr8_primer_v2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.korobeynikova.pr8_primer_v2.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.loseButton.isEnabled = false
        binding.loseButton.isEnabled = false

        binding.startButton.setOnClickListener {
            button()
        }
    }

    private fun button() {
        binding.loseButton.isEnabled = true
        binding.loseButton.isEnabled = true
        binding.startButton.isEnabled = false

        generatePrimer()
    }

    private fun generatePrimer(){

        val numberOne = Random.nextInt(10, 100)
        val numberTwo = Random.nextInt(10, 100)
        val operators = arrayOf('+', '-', '*', '/')

        val operator = operators.random()

        binding.nullNull1.text = numberOne.toString()
        binding.nullNull2.text = numberTwo.toString()
        binding.znak.text = operator.toString()
    }
}