package com.example.mediamonkstest.di

import com.example.mediamonkstest.domain.api.RetrofitManager
import com.example.mediamonkstest.domain.local.RoomManager
import com.example.mediamonkstest.domain.repository.AlbumRepository
import com.example.mediamonkstest.domain.repository.AlbumRepositoryImpl
import com.example.mediamonkstest.domain.repository.PhotoRepository
import com.example.mediamonkstest.domain.repository.PhotoRepositoryImpl
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val appModule = module {
    single { RetrofitManager() }
    single { RoomManager(androidContext()) }
    single<AlbumRepository> { AlbumRepositoryImpl(get(), get()) }
    single<PhotoRepository> { PhotoRepositoryImpl(get(), get()) }

}
