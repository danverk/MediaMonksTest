package com.example.mediamonkstest.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.mediamonkstest.R
import com.example.mediamonkstest.domain.api.RetrofitManager
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //test
        CoroutineScope(Dispatchers.IO).launch {
            val retrofitManager: RetrofitManager by inject()
            val response = retrofitManager.service.getPhotos().execute()

            val isSuccessful = response.isSuccessful
            val body = response.body()
        }
    }
}