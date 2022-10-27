package com.vivek.androidmvvm.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.vivek.androidmvvm.R
import com.vivek.androidmvvm.utilites.Utility

class UserListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_list)
        hideActionBar()

    }

    private fun hideActionBar() {
        try {
            this.supportActionBar!!.hide()
        } // catch block to handle NullPointerException
        catch (e: NullPointerException) {
            TODO()
        }

    }
}