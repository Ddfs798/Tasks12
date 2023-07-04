package com.example.task1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var nameEditText: EditText
    private lateinit var heightEditText: EditText
    private lateinit var weightEditText: EditText
    private lateinit var ageEditText: EditText
    private lateinit var calculateButton: Button
    private lateinit var resultTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        nameEditText = findViewById(R.id.editTextName)
        ageEditText = findViewById(R.id.editTextAge)
        heightEditText = findViewById(R.id.editTextHeight)
        weightEditText = findViewById(R.id.editTextWeight)
        calculateButton = findViewById(R.id.button2)
        resultTextView = findViewById(R.id.textView2)

        calculateButton.setOnClickListener {
            calculateBMI()
        }
    }

    private fun calculateBMI() {
        val name = nameEditText.text.toString()
        val height = heightEditText.text.toString().toFloatOrNull()
        val weight = weightEditText.text.toString().toFloatOrNull()
        val age = ageEditText.text.toString().toIntOrNull()

        if (name.isEmpty() || name.length > 50) {
            resultTextView.text = "Некорректное значение имени.\nПожалуйста, введите имя."
        } else if (height == null || weight == null || age == null) {
            resultTextView.text = "Данные введены некорректно."
        } else if (age < 0 || age > 150) {
            resultTextView.text = "Некорректное значение возраста.\nВведите значение от 0 до 150."
        } else if (height < 0 || height > 250 || weight < 0 || weight > 250) {
            resultTextView.text = "Некорректные значения роста или веса. \nВведите значения от 0 до 250."
        } else {
            val bmi = calculateBMIValue(height, weight)
            val degree: String = when (bmi) {
                in Double.MIN_VALUE..18.4 -> "Недостаточная масса тела"
                in 18.5..24.9 -> "Нормальная масса тела"
                in 25.0..29.9 -> "Избыточная масса тела"
                in 30.0..34.9 -> "Ожирение I степени"
                in 35.0..39.9 -> "Ожирение II степени"
                else -> "Ожирение III степени"
            }
            resultTextView.text = "$name, ваш ИМТ:  $bmi,\n$degree"
        }
    }

    private fun calculateBMIValue(height: Float, weight: Float): Float {
        val heightInMeters = height / 100
        return weight / (heightInMeters * heightInMeters)
    }
}
