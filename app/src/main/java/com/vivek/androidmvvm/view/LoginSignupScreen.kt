package com.vivek.androidmvvm.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.vivek.androidmvvm.R
import com.vivek.androidmvvm.utilites.Utility

class LoginSignupScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_signup_screen)
        Utility.makeFullScreen(this)
        supportActionBar?.hide()
    }
}