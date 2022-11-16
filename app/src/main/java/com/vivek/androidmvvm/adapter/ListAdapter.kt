package com.vivek.androidmvvm.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.vivek.androidmvvm.R
import com.vivek.androidmvvm.model.Question
import kotlinx.android.synthetic.main.card_view_design.view.*

class ListAdapter(private val context: Context, private val mQuestions: List<Question>, private val mRowLayout: Int) : RecyclerView.Adapter<ListAdapter.QuestionViewHolder>() {


    class QuestionViewHolder(val containerView: View) : RecyclerView.ViewHolder(containerView) {
        val positionNumber = containerView.positionNumber!!;
        val title = containerView.title!!;
        val link = containerView.link!!;
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuestionViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(mRowLayout, parent, false)
        return QuestionViewHolder(view)

    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: QuestionViewHolder, position: Int) {


//        holder.positionNumber.text = context.resources.getString(R.string.question_num, position + 1)
        holder.positionNumber.text = "Question " + (position+1).toString()
        holder.title.text = "Title "+ mQuestions[position].title.toString()
        holder.link.text = "Link "+ mQuestions[position].link.toString()

        holder.containerView.setOnClickListener {
            Toast.makeText(context, "Clicked on: " + holder.title.text, Toast.LENGTH_SHORT).show();
        }

    }

    override fun getItemCount(): Int {
        return mQuestions.size

    }

}