package com.example.mediamonkstest.di

import com.example.mediamonkstest.domain.api.RetrofitManager
import com.example.mediamonkstest.domain.local.RoomManager
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val appModule = module {
    single { RetrofitManager() }
    single { RoomManager(androidContext()) }

}
