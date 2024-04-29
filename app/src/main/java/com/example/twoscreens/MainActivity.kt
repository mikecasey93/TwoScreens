package com.example.twoscreens

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.twoscreens.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        fun verifyEmail(email: String): Boolean {
            return !TextUtils.isEmpty(email) && android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
        }

        fun verifyPassword(password: String): Boolean {
            var lowerCase: Boolean = false
            var upperCase: Boolean = false
            var specialChar: Boolean = false
            if (password.length < 8) {
                return false
            }
            else {
                for (i in password) {
                    if (i.isLowerCase()) {
                        lowerCase = true
                    }
                    if (i.isUpperCase()) {
                        upperCase = true
                    }
                    if (!i.isDigit() && !i.isLetter()) {
                        specialChar = true
                    }
                }
            }
            if(lowerCase && upperCase && specialChar) {
                return true
            }
            return false
        }

        binding.tvSignUp.setOnClickListener{
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }

        binding.tvSignUp2.setOnClickListener{
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }

        binding.btnSignIn.setOnClickListener {
            val submittedEmail = binding.etUserName.text.toString()
            val submittedPassword = binding.etPassword.text.toString()

            if (verifyEmail(submittedEmail) && verifyPassword(submittedPassword)) {
                Toast.makeText(this, "You Logged In!", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, SignUpActivity::class.java)
                startActivity(intent)
            }
            else {
                Toast.makeText(this, "Invalid username or Password", Toast.LENGTH_LONG).show()
            }

        }
        //enableEdgeToEdge()
        //setContentView(R.layout.activity_main)
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }
    }
}