package com.example.projectmana.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.WindowManager
import android.widget.Button
import com.example.projectmana.R

class IntroActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intro)

        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
        )

        Log.d("IntroActivity: oncreate", "IntroActivity")

        val btnSignUp: Button = findViewById(R.id.btn_sign_up_intro);
        btnSignUp.setOnClickListener { startActivity(Intent(this, SignUpActivity::class.java)) }

        val btnSignIn: Button = findViewById(R.id.btn_sign_in_intro);
        btnSignIn.setOnClickListener { startActivity(Intent(this, SignInActivity::class.java)) }
    }
}