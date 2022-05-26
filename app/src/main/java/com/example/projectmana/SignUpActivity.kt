package com.example.projectmana

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.WindowManager
import android.widget.TextView
import androidx.appcompat.widget.Toolbar

class SignUpActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
        )

        setupActionBar()

    }

    private fun setupActionBar(){
        val toolbar: Toolbar = findViewById(R.id.toolbar_sign_up_activity);
        setSupportActionBar(toolbar);

        val actionBar = supportActionBar
        if(actionBar != null){
            Log.d("SignUp" ,actionBar.toString() )
            actionBar.setDisplayHomeAsUpEnabled(true)
            actionBar.setHomeAsUpIndicator(R.drawable.ic_baseline_arrow_back_ios_24)
        }

        toolbar.setNavigationOnClickListener {onBackPressed()}
    }
}