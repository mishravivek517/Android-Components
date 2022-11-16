package com.vivek.androidmvvm.view

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.vivek.androidmvvm.R
import com.vivek.androidmvvm.adapter.ListAdapter
import com.vivek.androidmvvm.databinding.ActivityUserListBinding
import com.vivek.androidmvvm.model.Question
import com.vivek.androidmvvm.model.QuestionList
import com.vivek.androidmvvm.networking.RetrofitInstance
import com.vivek.androidmvvm.networking.RetrofitService
import com.vivek.androidmvvm.utilites.Utility
import kotlinx.android.synthetic.main.activity_user_list.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserListActivity : AppCompatActivity() {

    private var mApiService: RetrofitService? = null
    private var mAdapter: ListAdapter? = null
    private var mQuestions: MutableList<Question> = ArrayList()
    private lateinit var binding: ActivityUserListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_list)
        binding = ActivityUserListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Utility.makeFullScreen(this)
        supportActionBar?.hide()
        progressDialog.visibility = View.VISIBLE
        mApiService = RetrofitInstance.client.create(RetrofitService::class.java)

        listRecyclerView!!.layoutManager = LinearLayoutManager(this)
        mAdapter = ListAdapter(this, mQuestions, R.layout.card_view_design)
        listRecyclerView!!.adapter = mAdapter

        fetchQuestionList()

//         val viewModel = ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory.getInstance(application)).get(MainActivityViewModel::class.java)
//        viewModel.getPost()
//        viewModel.myResponse.observe(this, Observer {
//
//            Log.e("RESPONSEder",  " "+ it.body)
//            Log.e("RESPONSEder"," "+ it.title)
//            Log.e("RESPONSEder"," "+ it.userId.toString())
//            Log.e("RESPONSEder"," "+ it.id.toString())
//        })
//
//        viewModel.getPostList()
//        viewModel.myResponseList.observe(this, Observer {
//            for (user in it) {
//                Log.d("RESPONSEder"," "+ user.body)
//                Log.d("RESPONSEder", " "+user.title)
//                Log.d("RESPONSEder", " "+user.id.toString())
//                Log.d("RESPONSEder", " "+user.userId.toString())
//            }
//        })

    }

    @SuppressLint("SuspiciousIndentation")
    private fun fetchQuestionList() {

        val call = mApiService!!.fetchQuestions("android")

        call.enqueue(object : Callback<QuestionList> {
            @SuppressLint("NotifyDataSetChanged")
            override fun onResponse(
                call: Call<QuestionList>,
                response: Response<QuestionList>
            ) {
                progressDialog.visibility = View.GONE
                Log.d("GG", "Total Questions: " + response.body()!!.items!!.size)
                val questions = response.body()
                if (questions != null) {
                    mQuestions.addAll(questions.items!!)
                    mAdapter!!.notifyDataSetChanged()
                }
            }

            override fun onFailure(call: Call<QuestionList>, t: Throwable) {
                Log.e("GG", "Got error : " + t.localizedMessage)
            }


        })

    }
}
