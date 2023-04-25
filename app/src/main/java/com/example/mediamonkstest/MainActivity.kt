package com.example.mediamonkstest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mediamonkstest.domain.api.RetrofitManager
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //test
        CoroutineScope(Dispatchers.IO).launch {
            val response = RetrofitManager().service.getAlbums().execute()

            val isSuccessful = response.isSuccessful
            val body = response.body()
        }
    }
}