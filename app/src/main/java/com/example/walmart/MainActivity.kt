package com.example.walmart

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import java.io.Serializable

class MainActivity : AppCompatActivity() {
    var userList = arrayOf(
        User("John", "Doe", "john_doe@wm.com", "Test123"),
        User("Mary", "Jane", "mary_jane@wm.com", "Test123"),
        User("John", "Cena", "john_cena@wm.com", "Test123"),
        User("Arya", "Stark", "arya_stark@wm.com", "Test123"),
        User("Tyson", "Fury", "tyson_fury@wm.com", "Test123"),
    );
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        signIn()
        gotoSignUp()
        onInit()
        forgotPassword()
    }

    fun forgotPassword() {
        val forgotLink = findViewById<TextView>(R.id.forgotPassword)
        forgotLink.setOnClickListener{
            val emailIntent = Intent(Intent.ACTION_SEND)
            val email = findViewById<EditText>(R.id.email)
            emailIntent.type = "text/plain"
            emailIntent.putExtra(Intent.EXTRA_EMAIL, arrayOf(email.text.toString()))
            emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Your password")

            startActivity(Intent.createChooser(emailIntent, "Send Email"))
            Toast.makeText(this, "Password is sent!", Toast.LENGTH_SHORT).show()
        }
    }

    fun onInit() {
        var sintent = intent
        val user = sintent.getSerializableExtra("newUser")
        if(user != null) {
            userList = userList + user as User
            println("new user added" + userList.get(5).firstName)
        }
    }

    fun gotoSignUp() {
        val signUp = findViewById<Button>(R.id.createAccount)

        signUp.setOnClickListener{
            val intent = Intent(this, SignUp::class.java)
            startActivity(intent)
        }
    }

    fun signIn() {
        val signIn = findViewById<Button>(R.id.signIn)
        signIn.setOnClickListener{
            var flag = true
            val email = findViewById<EditText>(R.id.email)
            val password = findViewById<EditText>(R.id.password)
            for(user in userList) {
                if(user.email == email.text.toString() && user.password == password.text.toString()) {
                    Toast.makeText(this, "Log in success!", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this, Home::class.java)
                    intent.putExtra("user", user.firstName + " " + user.lastName)
                    startActivity(intent)
                    flag = false
                    break
                }
            }
            if(flag) {
                Toast.makeText(this, "Incorrect email or password!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}

data class User(
    val firstName: String,
    val lastName: String,
    val email: String,
    val password: String
):Serializable