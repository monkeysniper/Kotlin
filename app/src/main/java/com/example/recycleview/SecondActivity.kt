package com.example.recycleview

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {
    private var logInBtn: Button? = null
    private var emailEditText: EditText? = null
    private var passwordEditText: EditText? = null
    private var logIN: Button? = null
    private val email: String = "admin"
    private val password: String = "admin"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.enableEdgeToEdge()
        setContentView(R.layout.activity_second)

        logIN = findViewById(R.id.loginButton)
        emailEditText = findViewById(R.id.emailEditText)
        passwordEditText = findViewById(R.id.passwordEditText)
        logInBtn = findViewById(R.id.loginButton)

        logIN?.setOnClickListener {
            val enteredEmail = emailEditText?.text.toString()
            val enteredPassword = passwordEditText?.text.toString()

            if (email == enteredEmail && password == enteredPassword) {
                Toast.makeText(
                    this@SecondActivity,
                    "Вы успешно зарегистрировались",
                    Toast.LENGTH_SHORT
                ).show()

                val intent = Intent(this@SecondActivity, ThirdActivity::class.java)
                startActivity(intent)

                // Скрываем элементы интерфейса после успешного входа
                emailEditText?.visibility = View.GONE
                passwordEditText?.visibility = View.GONE
                logInBtn?.visibility = View.GONE
            } else {
                Toast.makeText(
                    this@SecondActivity,
                    "Неправильный логин или пароль",
                    Toast.LENGTH_SHORT
                ).show()
            }

            // Очищаем поля ввода
            emailEditText?.setText("")
            passwordEditText?.setText("")
        }
    }
}