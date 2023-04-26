package com.example.mediamonkstest.view.album

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mediamonkstest.R
import com.example.mediamonkstest.view.ListItemOnClickCallback
import android.content.Intent
import com.example.mediamonkstest.view.photo.PhotosActivity


class AlbumsActivity : AppCompatActivity(), ListItemOnClickCallback {

    private val viewmodel by viewModels<AlbumsViewModel>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_albums)

        viewmodel.state.observe(this, Observer {
            when (it) {
                is AlbumsViewModelState.Error -> {
                    Toast.makeText(baseContext, it.message, Toast.LENGTH_LONG).show()
                }
                is AlbumsViewModelState.DataReady -> {

                    val recyclerView = findViewById<RecyclerView>(R.id.recycler_view_albums)
                    recyclerView.layoutManager = LinearLayoutManager(baseContext)

                    recyclerView.adapter = AlbumsAdapter(it.list, this)
                }
            }
        })

        viewmodel.loadAlbums()
    }

    override fun onListItemClick(itemId: Int) {
        val intent = Intent(this, PhotosActivity::class.java)
        val bundle = Bundle()
        bundle.putInt("albumId", itemId)
        intent.putExtras(bundle)
        startActivity(intent)
    }
}