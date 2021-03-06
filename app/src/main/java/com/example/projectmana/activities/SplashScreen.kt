package com.example.projectmana.activities

import android.content.Intent
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.WindowManager
import android.widget.TextView
import com.example.projectmana.R
import com.example.projectmana.firebase.FirestoreClass

class SplashScreen : AppCompatActivity() {

    private fun setFlag(){
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
        )
    }

    private fun setTypeFace (){
        val typeFace: Typeface = Typeface.createFromAsset(assets, "carbon bl.ttf")
        val titleName: TextView = findViewById(R.id.tv_app_name);
        titleName.typeface = typeFace
    }

    private fun navigateIntroScreen (){
        Handler().postDelayed({

            val currentUserID = FirestoreClass().getCurrentUserID()
            if( currentUserID.isNotEmpty()){
                startActivity(Intent(this, MainActivity::class.java))
            }else{
                startActivity(Intent(this, IntroActivity::class.java))
            }

            finish()
        }, 2500)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        Log.d("SplashScreen: oncreate ", "SplashScreen")

        setFlag()
        setTypeFace()



        navigateIntroScreen()

    }
}