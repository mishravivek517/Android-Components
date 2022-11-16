package com.vivek.androidmvvm.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vivek.androidmvvm.model.Question
import com.vivek.androidmvvm.networking.RetrofitInstance
import kotlinx.coroutines.launch

class MainActivityViewModel : ViewModel() {

    val myResponse: MutableLiveData<Question> = MutableLiveData()
    val myResponseList: MutableLiveData<List<Question>> = MutableLiveData()



//    fun getPost() {
//        viewModelScope.launch {
//            myResponse.value = RetrofitInstance.retrofit.getPost()
//        }
//    }
//        fun getPostList(){
//            viewModelScope.launch {
//                myResponseList.value = RetrofitInstance.retrofit.getPosts()
//            }
//        }

//    fun getUserData(){
//        viewModelScope.launch {
//            myUserList.value = RetrofitInstance.retrofit.getUsers()
//        }
//
//    }

}