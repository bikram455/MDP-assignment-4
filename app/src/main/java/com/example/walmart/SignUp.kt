package com.example.walmart

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class SignUp : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        createAccount()
    }

    fun createAccount() {
        val firstName = findViewById<EditText>(R.id.firstName)
        val lastName = findViewById<EditText>(R.id.lastName)
        val email = findViewById<EditText>(R.id.email)
        val password = findViewById<EditText>(R.id.password)
        val create = findViewById<Button>(R.id.create)

        create.setOnClickListener{
            if(!TextUtils.isEmpty(firstName.text) && !TextUtils.isEmpty(lastName.text)
                && !TextUtils.isEmpty(email.text) && !TextUtils.isEmpty(password.text)) {
                Toast.makeText(this, "Account created!", Toast.LENGTH_SHORT).show()
                var intent = Intent(this, MainActivity::class.java)
                val newUser = User(firstName.text.toString(), lastName.text.toString(), email.text.toString(), password.text.toString())
                intent.putExtra("newUser", newUser)
                startActivity(intent)
            }
        }
    }
}