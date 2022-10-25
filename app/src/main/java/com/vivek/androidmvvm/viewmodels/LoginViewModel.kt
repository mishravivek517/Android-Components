package com.vivek.androidmvvm.viewmodels

import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.vivek.androidmvvm.model.LoginUser


class LoginViewModel : ViewModel() {
    var emailAddress = MutableLiveData<String>()
    var password = MutableLiveData<String>()
    private var userMutableLiveData: MutableLiveData<LoginUser>? = null
    val user: MutableLiveData<LoginUser>
        get() {
            if (userMutableLiveData == null) {
                userMutableLiveData = MutableLiveData()
            }
            return userMutableLiveData!!
        }

    fun onClick(view: View?) {
        val loginUser = LoginUser(emailAddress.value!!, password.value!!)
        userMutableLiveData!!.value = loginUser
    }
}