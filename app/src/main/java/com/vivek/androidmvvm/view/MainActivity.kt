package com.vivek.androidmvvm.view

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.vivek.androidmvvm.R
import com.vivek.androidmvvm.utilites.Utility

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Utility.makeFullScreen(this)
        supportActionBar?.hide()

        navigateToLoginSignup()
    }

    private fun navigateToLoginSignup() {
        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this, LoginSignupScreen::class.java)
            startActivity(intent)
            finish()
        }, 4000)

    }
}