package com.example.apiuse

import android.app.Activity
import android.media.Rating
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView
import com.squareup.picasso.Picasso

class MyAdapter(val context: Activity, val productArrayList: List<Product>):
    RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(context).inflate(R.layout.each_item, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = productArrayList[position]
        holder.title.text = currentItem.title
        // we can do like this.
        // holder.image.setImageResource(currentItem.thumbnail)
        // Hence---------------------------------------------------
        // image view , how to show image in image view if the image is in form of url, 3rd Party Library
        // Picasso
        Picasso.get().load(currentItem.thumbnail).into(holder.image)
        holder.myRating.rating = currentItem.rating.toFloat()
    }

    override fun getItemCount(): Int {
        return productArrayList.size
    }

    class MyViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        val title: TextView
        val image : ShapeableImageView
        val myRating: RatingBar

        init {
            title = itemView.findViewById(R.id.productTitle)
            image = itemView.findViewById(R.id.productImage)
            myRating = itemView.findViewById(R.id.ratingBar)
        }
    }
}

