package com.example.mediamonkstest.di

import com.example.mediamonkstest.domain.api.RetrofitManager
import org.koin.dsl.module

val appModule = module {
    single { RetrofitManager() }
}
