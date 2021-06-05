package com.example.calcul

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class StartActivity : AppCompatActivity() {

    private val SHARED = "SH"
    private val TEXT = "t"

    private var firstValue = ""
    private var secValue = ""
    private var thirdValue = ""
    private var fourthValue = ""
    private var fiveValue = ""

    private lateinit var allValues: TextView
    private lateinit var currentValue: TextView
    private lateinit var saveBtn: Button
    private lateinit var calcBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)

        init()
        loadDataAndUpdateView()
    }

    private fun init() {
        allValues = findViewById(R.id.all_values)
        currentValue = findViewById(R.id.current_value)
        saveBtn = findViewById(R.id.save_btn)
        calcBtn = findViewById(R.id.calcul_btn)
    }

    override fun onStart() {
        super.onStart()
        goToMainActivity()
        saveSharedPrefAndSetAllValues()
    }

    private fun goToMainActivity() {
        calcBtn.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivityForResult(intent, 1)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (data == null) {
            return
        }
        val currentNumber = data.getStringExtra("EXTRA_CURRENT_NUMBER")
        currentValue.text = currentNumber
    }

    private fun setText() {
        allValues.text = " $firstValue\n $secValue\n $thirdValue\n $fourthValue\n $fiveValue"
    }

    private fun saveSharedPrefAndSetAllValues() {
        saveBtn.setOnClickListener {
            if(firstValue == ""){
                firstValue = currentValue.text.toString()
                setText()
            }else if(secValue == ""){
                secValue = currentValue.text.toString()
                setText()
            }else if(thirdValue == ""){
                thirdValue = currentValue.text.toString()
                setText()
            } else if(fourthValue == ""){
                fourthValue = currentValue.text.toString()
                setText()
            }else if(fiveValue == ""){
                fiveValue = currentValue.text.toString()
                setText()
            } else if (firstValue != "" && secValue != "" && thirdValue != "" && fourthValue != "" && firstValue != "") {
                fiveValue = fourthValue
                fourthValue = thirdValue
                thirdValue = secValue
                secValue = firstValue
                firstValue = currentValue.text.toString()
                setText()
            }
        }
        setData()
    }

    private fun setData() {
        val text = allValues.text.toString()
        getSharedPreferences(SHARED, Context.MODE_PRIVATE)
            .edit()
            .apply{
            putString(TEXT, text)
        }.apply()
        Toast.makeText(this, "SharedPref is completed!",Toast.LENGTH_LONG).show()
    }

    private fun loadDataAndUpdateView(){
        allValues.text = getSharedPreferences(SHARED, Context.MODE_PRIVATE).getString(TEXT, null)
    }

    override fun onStop() {
        super.onStop()
        saveBtn.setOnClickListener(null)
        calcBtn.setOnClickListener(null)
    }
}