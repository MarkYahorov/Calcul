package com.example.calcul

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import java.math.RoundingMode

class MainActivity : AppCompatActivity() {

    private val PLUS = 1
    private val MINUS = 2
    private val MULTIPLY = 3
    private val DEVIDE = 4

    private var isFirstPressed: Boolean = true
    private var mathFunction: Int = 0
    private var number1: Int = 0
    private var number2: Int = 0

    private lateinit var ziroBtn: Button
    private lateinit var oneBtn: Button
    private lateinit var twoBtn: Button
    private lateinit var threeBtn: Button
    private lateinit var fourBtn: Button
    private lateinit var fiveBtn: Button
    private lateinit var sixBtn: Button
    private lateinit var sevenBtn: Button
    private lateinit var eightBtn: Button
    private lateinit var nineBtn: Button
    private lateinit var equalsBtn: Button
    private lateinit var plusBtn: Button
    private lateinit var minusBtn: Button
    private lateinit var multiplyBtn: Button
    private lateinit var deleteBtn: Button
    private lateinit var cleanBtn: Button
    private lateinit var numbersText: TextView
    private lateinit var resultText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initAll()
    }

    private fun initAll() {
        ziroBtn = findViewById(R.id.ziro_btn)
        oneBtn = findViewById(R.id.one_btn)
        twoBtn = findViewById(R.id.two_btn)
        threeBtn = findViewById(R.id.three_btn)
        fourBtn = findViewById(R.id.four_btn)
        fiveBtn = findViewById(R.id.five_btn)
        sixBtn = findViewById(R.id.six_btn)
        sevenBtn = findViewById(R.id.seven_btn)
        eightBtn = findViewById(R.id.eight_btn)
        nineBtn = findViewById(R.id.nine_btn)
        equalsBtn = findViewById(R.id.equals_btn)
        plusBtn = findViewById(R.id.plus_btn)
        minusBtn = findViewById(R.id.minus_btn)
        multiplyBtn = findViewById(R.id.multiply_btn)
        deleteBtn = findViewById(R.id.delete_btn)
        cleanBtn = findViewById(R.id.clean_btn)
        numbersText = findViewById(R.id.numbers)
        resultText = findViewById(R.id.equations_and_result)
    }

    override fun onStart() {
        super.onStart()
        setListenersAllBtn()
    }

    private fun setListenersAllBtn() {

        var result = 0

        ziroBtn.setOnClickListener {
            setTextFields("0")
        }
        oneBtn.setOnClickListener {
            setTextFields("1")
        }
        twoBtn.setOnClickListener {
            setTextFields("2")
        }
        threeBtn.setOnClickListener {
            setTextFields("3")
        }
        fourBtn.setOnClickListener {
            setTextFields("4")
        }
        fiveBtn.setOnClickListener {
            setTextFields("5")
        }
        sixBtn.setOnClickListener {
            setTextFields("6")
        }
        sevenBtn.setOnClickListener {
            setTextFields("7")
        }
        eightBtn.setOnClickListener {
            setTextFields("8")
        }
        nineBtn.setOnClickListener {
            setTextFields("9")
        }
        equalsBtn.setOnClickListener {
            if (isFirstPressed) {
                number2 = numbersText.text.toString().toInt()
                isFirstPressed = false
            }
            checkMathOperation()
        }
        plusBtn.setOnClickListener {
            isFirstPressed = true
            number1 = numbersText.text.toString().toInt()
            mathFunction = PLUS
            resultText.text = ""
        }
        minusBtn.setOnClickListener {
            isFirstPressed = true
            number1 = numbersText.text.toString().toInt()
            mathFunction = MINUS
            resultText.text = ""
        }
        multiplyBtn.setOnClickListener {
            isFirstPressed = true
            number1 = numbersText.text.toString().toInt()
            mathFunction = MULTIPLY
            resultText.text = ""
        }
        deleteBtn.setOnClickListener {
            isFirstPressed = true
            number1 = numbersText.text.toString().toInt()
            mathFunction = DEVIDE
            resultText.text = ""
        }
        cleanBtn.setOnClickListener {
            numbersText.text = ""
        }
    }

    private fun setTextFields(str: String) {
        numbersText.append(str)
    }

    private fun checkMathOperation() {
        when (mathFunction) {
            PLUS -> {
                number1 += number2
                resultText.text = number1.toInt().toString()
            }
            MINUS -> {
                number1 -= number2
                resultText.text = number1.toInt().toString()
            }
            MULTIPLY -> {
                number1 *= number2
                resultText.text = number1.toInt().toString()
            }
            DEVIDE -> {
                if (resultText.text.toString() != "0") {
                    number1 /= number2
                    resultText.text = number1.toInt().toString()
                } else {
                    resultText.text = "Error"
                }
            }
        }
    }
}