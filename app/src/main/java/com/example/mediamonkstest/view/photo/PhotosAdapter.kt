package com.example.mediamonkstest.view.photo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mediamonkstest.R
import com.example.mediamonkstest.view.ListItemOnClickCallback
import com.squareup.picasso.Picasso


class PhotosAdapter(
    val photoItemList: List<PhotoItem>,
    val listItemOnClickCallback: ListItemOnClickCallback
) :
    RecyclerView.Adapter<PhotoListItemViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoListItemViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.photo_item, parent, false)
        return PhotoListItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: PhotoListItemViewHolder, position: Int) {
        val item = photoItemList[position]
        holder.itemView.findViewById<TextView>(R.id.text_view_photo_title).text = item.title
        Picasso.get().load(item.thumbnailUrl)
            .into(holder.itemView.findViewById<ImageView>(R.id.image_view_photo_thumbnail));
        holder.itemView.setOnClickListener { listItemOnClickCallback.onListItemClick(item.photoId) }
    }

    override fun getItemCount(): Int {
        return photoItemList.size
    }

}

class PhotoListItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)