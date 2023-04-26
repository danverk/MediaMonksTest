package com.example.mediamonkstest.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mediamonkstest.R


class AlbumsAdapter(
    val albumItemList: List<AlbumItem>,
    val listItemOnClickCallback: ListItemOnClickCallback
) :
    RecyclerView.Adapter<AlbumListItemViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlbumListItemViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.album_item, parent, false)
        return AlbumListItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: AlbumListItemViewHolder, position: Int) {
        val item = albumItemList[position]
        holder.itemView.findViewById<TextView>(R.id.text_view_album_title).text = item.title
        holder.itemView.setOnClickListener { listItemOnClickCallback.onListItemClick(item.albumId) }
    }

    override fun getItemCount(): Int {
        return albumItemList.size
    }

}

class AlbumListItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)