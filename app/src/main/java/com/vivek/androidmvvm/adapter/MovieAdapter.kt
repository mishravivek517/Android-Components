package com.vivek.androidmvvm.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.vivek.androidmvvm.R
import com.vivek.androidmvvm.model.Movie

class MovieAdapter : RecyclerView.Adapter<MovieAdapter.ViewHolder>() {


    var listDataUser: List<Movie>? = null

    fun setListData(listDataUser: List<Movie>) {
        this.listDataUser = listDataUser
    }

    // create new views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // inflates the card_view_design view
        // that is used to hold list item
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_view_design, parent, false)

        return ViewHolder(view)
    }

    // binds the list items to a view
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val itemsViewModel = listDataUser?.get(position)

        // sets the image to the imageview from our itemHolder class
//        holder.imageView.setImageResource(ItemsViewModel.image)
        Glide.with(holder.imageView)
            .load(itemsViewModel?.avatar)
            .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
//            .placeholder(shimmerDrawable)
            .centerCrop()
            .fitCenter()
            .into(holder.imageView)
        // sets the text to the textview from our itemHolder class
        holder.textView.text = itemsViewModel?.first_name

    }

    // return the number of the items in the list
    override fun getItemCount(): Int {
        if (listDataUser == null) return 0
        return listDataUser?.size!!
    }

    // Holds the views for adding it to image and text
    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val imageView: ImageView = itemView.findViewById(R.id.imageview)
        val textView: TextView = itemView.findViewById(R.id.name)
    }
}