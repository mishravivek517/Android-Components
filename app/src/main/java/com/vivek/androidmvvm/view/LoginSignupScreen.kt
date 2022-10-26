package com.vivek.androidmvvm.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Toast
import com.vivek.androidmvvm.R
import com.vivek.androidmvvm.utilites.Utility
import kotlinx.android.synthetic.main.activity_login_signup_screen.*

class LoginSignupScreen : AppCompatActivity() {

    fun String.isValidEmail() =
        isNotEmpty() && android.util.Patterns.EMAIL_ADDRESS.matcher(this).matches()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_signup_screen)
        Utility.makeFullScreen(this)
        supportActionBar?.hide()
        buttonLogin.setOnClickListener {
        val email  =  txtEmail.text.toString()

            if (email.isEmpty() && txtPassword.text.toString().isEmpty()){
                Toast.makeText(this, "Email and Password can not be empty", Toast.LENGTH_SHORT).show()
            }
         else if (email.isValidEmail() && txtPassword.text.toString().length>7){
                Utility.showProgress(this)
            }else {
                Toast.makeText(this, "A valid Email and 8 character password is mandatory", Toast.LENGTH_SHORT).show()
            }
            //Utility.showProgress(this)
        }


    }

}