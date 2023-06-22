package com.geektech.rickandmorty

import android.app.Application
import com.geektech.rickandmorty.di.networkModule
import com.geektech.rickandmorty.di.repoModule
import com.geektech.rickandmorty.di.useCaseModule
import com.geektech.rickandmorty.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(listOf(networkModule, repoModule, viewModelModule, useCaseModule))
        }
    }

}