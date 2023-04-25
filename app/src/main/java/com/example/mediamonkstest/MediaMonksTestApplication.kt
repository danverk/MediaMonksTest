package com.example.mediamonkstest

import android.app.Application
import com.example.mediamonkstest.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin

class MediaMonksTestApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@MediaMonksTestApplication)
            modules(appModule)
        }
    }
}