package com.example.mediamonkstest.view.photo

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mediamonkstest.R
import com.example.mediamonkstest.view.ListItemOnClickCallback

class PhotosActivity : AppCompatActivity(), ListItemOnClickCallback {

    private val viewmodel by viewModels<PhotosViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_photos)

        val albumId = intent.extras?.getInt("albumId")

        viewmodel.state.observe(this, Observer {
            when (it) {
                is PhotosViewModelState.Error -> {
                    Toast.makeText(baseContext, it.message, Toast.LENGTH_LONG).show()
                }
                is PhotosViewModelState.DataReady -> {

                    val recyclerView = findViewById<RecyclerView>(R.id.recycler_view_photos)
                    recyclerView.layoutManager = LinearLayoutManager(baseContext)

                    recyclerView.adapter = PhotosAdapter(it.list, this)
                }
            }
        })

        viewmodel.loadPhotosByAlbumId(albumId ?: 0)
    }

    override fun onListItemClick(itemId: Int) {
        val intent = Intent(this, PhotoDetailActivity::class.java)
        val bundle = Bundle()
        bundle.putInt("photoId", itemId)
        intent.putExtras(bundle)
        startActivity(intent)
    }
}