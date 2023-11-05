package com.example.walmart

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast

class Home : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        onInit()
        itemListener()
    }

    fun onInit() {
        var sintent = intent
        val user = sintent.getStringExtra("user");
        val welcome = findViewById<TextView>(R.id.welcome)
        welcome.text = "Welcome " + user
    }

    fun itemListener() {
        val food = findViewById<LinearLayout>(R.id.food)
        val beauty = findViewById<LinearLayout>(R.id.beauty)
        val clothing = findViewById<LinearLayout>(R.id.clothing)
        val electronics = findViewById<LinearLayout>(R.id.electronics)

        food.setOnClickListener{
            Toast.makeText(this, "You have chosen the Food category of shopping!", Toast.LENGTH_SHORT).show()
        }
        beauty.setOnClickListener{
            Toast.makeText(this, "You have chosen the Beauty category of shopping!", Toast.LENGTH_SHORT).show()
        }
        clothing.setOnClickListener{
            Toast.makeText(this, "You have chosen the Clothing category of shopping!", Toast.LENGTH_SHORT).show()
        }
        electronics.setOnClickListener{
            Toast.makeText(this, "You have chosen the Electronics category of shopping!", Toast.LENGTH_SHORT).show()
        }

    }
}