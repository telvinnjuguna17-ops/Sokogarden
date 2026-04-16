package com.example.sokogarden

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ProgressBar
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


//        find the buttons by use of their ids
        val SigninButton = findViewById<Button>(R.id.signinBtn)
        val SignupButton = findViewById<Button>(R.id.signupBtn)

//        Create the intents to the two activities
        SignupButton.setOnClickListener {
            val intent = Intent(applicationContext, Signup::class.java)
            startActivity(intent)
        }
//        =====================================
        SigninButton.setOnClickListener {
            val intent = Intent(applicationContext, Signin::class.java)
            startActivity(intent)
        }
//        Find the recyclerview and progressbar by use of their ids
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerview)
        val progressBar = findViewById< ProgressBar>(R.id.progressbar)

//        specify the api endpoint for fetching data (alwaysdata)
        val url = "https://telvin.alwaysdata.net/api/get_products"

//        Import the helper class
        val helper = ApiHelper(applicationContext)

//        Inside of the helper class access the function loadproducts
        helper.loadProducts(url,recyclerView,progressBar)
    }

}