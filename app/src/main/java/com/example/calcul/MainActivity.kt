package com.example.calcul

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    /*здесь будуд храниться значения
    expressionsList[0] - первое число
    expressionsList[1] - оператор(+, -, *, /)
    expressionsList[2] - второе число
     */
    private val expressionsList = mutableListOf("", "", "")
    private val currentNumber = mutableListOf("")
    private val STATE = "STATE"

    private var result: Number = 0

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
    private lateinit var btnOk: Button

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
        btnOk = findViewById(R.id.btn_ok)
    }

    override fun onStart() {
        super.onStart()
        setListenersAllBtn()
    }

    private fun setListenersAllBtn() {
        ziroBtn.setOnClickListener {
            setTextFields("0")
            checkThisCell()
        }
        oneBtn.setOnClickListener {
            setTextFields("1")
            checkThisCell()
        }
        twoBtn.setOnClickListener {
            setTextFields("2")
            checkThisCell()
        }
        threeBtn.setOnClickListener {
            setTextFields("3")
            checkThisCell()
        }
        fourBtn.setOnClickListener {
            setTextFields("4")
            checkThisCell()
        }
        fiveBtn.setOnClickListener {
            setTextFields("5")
            checkThisCell()
        }
        sixBtn.setOnClickListener {
            setTextFields("6")
            checkThisCell()
        }
        sevenBtn.setOnClickListener {
            setTextFields("7")
            checkThisCell()
        }
        eightBtn.setOnClickListener {
            setTextFields("8")
            checkThisCell()
        }
        nineBtn.setOnClickListener {
            setTextFields("9")
            checkThisCell()

        }
        equalsBtn.setOnClickListener {
            calculationOfTheFinalExpressionAndDisplayingTheResultingValue()
            Toast.makeText(this, expressionsList[0], Toast.LENGTH_LONG).show()
        }
        plusBtn.setOnClickListener {
            mathOperation("+")
        }
        minusBtn.setOnClickListener {
            mathOperation("-")
        }
        multiplyBtn.setOnClickListener {
            mathOperation("*")
        }
        deleteBtn.setOnClickListener {
            mathOperation("/")
        }
        cleanBtn.setOnClickListener {
            numbersText.text = ""
            resultText.text = ""
            currentNumber[0] = ""
            expressionsList[0] = ""
            expressionsList[1] = ""
            expressionsList[2] = ""
        }
        btnOk.setOnClickListener {
            val intent = Intent()
                .putExtra("EXTRA_CURRENT_NUMBER", currentNumber[0])
            setResult(RESULT_OK, intent)
            finish()
        }
    }

    private fun setTextFields(str: String) {
        numbersText.append(str)
    }

    private fun checkThisCell() {
        if (expressionsList[0] == "" || expressionsList[0] != "" && expressionsList[1] == "") {
            expressionsList[0] = numbersText.text.toString()
        }
        if (expressionsList[0] != "" && expressionsList[1] != "") {
            expressionsList[2] = numbersText.text.toString()
        }
    }

    private fun calculationOfTheFinalExpressionAndDisplayingTheResultingValue() {
        if (expressionsList[0] != "" && expressionsList[1] != "" && expressionsList[2] != "") {
            if (expressionsList[1] != "/" && expressionsList[2] != "0") {
                mathOperation("")
                numbersText.text = currentNumber[0]
            } else {
                numbersText.text = "Error"
            }
        } else if (expressionsList[0] == "") {
            numbersText.text = ""
        } else if (expressionsList[0] != "" && expressionsList[1] == "") {
            numbersText.text = expressionsList[0]
        } else if (expressionsList[2] == "") {
            when {
                expressionsList[1] == "+" -> {
                    if (currentNumber[0] == "") {
                        result = expressionsList[0].toInt() + expressionsList[0].toInt()
                        currentNumber[0] = result.toString()
                        numbersText.text = currentNumber[0]
                    } else {
                        result = currentNumber[0].toInt() + expressionsList[0].toInt()
                        currentNumber[0] = result.toString()
                        numbersText.text = currentNumber[0]
                    }
                }
                expressionsList[1] == "-" -> {
                    if (currentNumber[0] == "") {
                        result = expressionsList[0].toInt() - expressionsList[0].toInt()
                        currentNumber[0] = result.toString()
                        numbersText.text = currentNumber[0]
                    } else {
                        result = currentNumber[0].toInt() - expressionsList[0].toInt()
                        currentNumber[0] = result.toString()
                        numbersText.text = currentNumber[0]
                    }
                }
                expressionsList[1] == "*" -> {
                    if (currentNumber[0] == "") {
                        result = expressionsList[0].toInt() * expressionsList[0].toInt()
                        currentNumber[0] = result.toString()
                        numbersText.text = currentNumber[0]
                    } else {
                        result = currentNumber[0].toInt() * expressionsList[0].toInt()
                        currentNumber[0] = result.toString()
                        numbersText.text = currentNumber[0]
                    }
                }
                expressionsList[1] == "/" -> {
                    if (currentNumber[0] == "") {
                        result = expressionsList[0].toInt() / expressionsList[0].toInt()
                        currentNumber[0] = result.toString()
                        numbersText.text = currentNumber[0]
                    } else {
                        result = currentNumber[0].toInt() / expressionsList[0].toInt()
                        currentNumber[0] = result.toString()
                        numbersText.text = currentNumber[0]
                    }
                }
            }
        }
    }

    private fun mathOperation(str: String) {
        if (expressionsList[0] != "" && expressionsList[1] == "" && expressionsList[2] == "") {
            expressionsList[1] = str
            numbersText.text = ""
        } else if (expressionsList[0] != "" && expressionsList[1] != "" && expressionsList[2] != "") {
            if (expressionsList[1] != "/" && expressionsList[2] != "0") {
                numbersText.text = ""
                when {
                    expressionsList[1] == "+" -> {
                        result = expressionsList[0].toInt() + expressionsList[2].toInt()
                        expressionsList[0] = result.toString()
                        currentNumber[0] = result.toString()
                        expressionsList[1] = str
                        expressionsList[2] = ""
                    }
                    expressionsList[1] == "-" -> {
                        result = expressionsList[0].toInt() - expressionsList[2].toInt()
                        expressionsList[0] = result.toString()
                        currentNumber[0] = result.toString()
                        expressionsList[1] = str
                        expressionsList[2] = ""
                    }
                    expressionsList[1] == "*" -> {
                        result = expressionsList[0].toInt() * expressionsList[2].toInt()
                        expressionsList[0] = result.toString()
                        currentNumber[0] = result.toString()
                        expressionsList[1] = str
                        expressionsList[2] = ""
                    }
                    expressionsList[1] == "/" -> {
                        result = expressionsList[0].toInt() / expressionsList[2].toInt()
                        expressionsList[0] = result.toString()
                        currentNumber[0] = result.toString()
                        expressionsList[1] = str
                        expressionsList[2] = ""
                    }
                }
            } else {
                numbersText.text = "Error"
                expressionsList[0] = ""
                expressionsList[1] = ""
                expressionsList[2] = ""
            }
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(STATE, expressionsList[0])
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        expressionsList[0] = savedInstanceState.getString(STATE).toString()
        numbersText.text = expressionsList[0]
    }

    override fun onStop() {
        super.onStop()
        ziroBtn.setOnClickListener(null)
        oneBtn.setOnClickListener(null)
        twoBtn.setOnClickListener(null)
        threeBtn.setOnClickListener(null)
        fourBtn.setOnClickListener(null)
        fiveBtn.setOnClickListener(null)
        sixBtn.setOnClickListener(null)
        sevenBtn.setOnClickListener(null)
        eightBtn.setOnClickListener(null)
        nineBtn.setOnClickListener(null)
        equalsBtn.setOnClickListener(null)
        plusBtn.setOnClickListener(null)
        minusBtn.setOnClickListener(null)
        multiplyBtn.setOnClickListener(null)
        deleteBtn.setOnClickListener(null)
        cleanBtn.setOnClickListener(null)
    }
}