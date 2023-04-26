package com.example.mediamonkstest.view.photo

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.mediamonkstest.R
import com.example.mediamonkstest.view.photodetail.PhotoDetailViewModel
import com.example.mediamonkstest.view.photodetail.PhotoDetailViewModelState
import com.squareup.picasso.Picasso

class PhotoDetailActivity : AppCompatActivity() {

    private val viewmodel by viewModels<PhotoDetailViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_photo_detail)

        val photoId = intent.extras?.getInt("photoId")

        viewmodel.state.observe(this, Observer {
            when (it) {
                is PhotoDetailViewModelState.Error -> {
                    Toast.makeText(baseContext, it.message, Toast.LENGTH_LONG).show()
                }
                is PhotoDetailViewModelState.DataReady -> {
                    findViewById<TextView>(R.id.text_view_photo_title_detail).text = it.item.title
                    Picasso.get().load(it.item.url)
                        .into(findViewById<ImageView>(R.id.image_view_photo_detail));
                }
            }
        })

        viewmodel.loadPhotoById(photoId ?: 0)
    }
}