package com.viktoriagavrosh.mylibrary

import android.app.Application
import com.viktoriagavrosh.mylibrary.data.AppContainer
import com.viktoriagavrosh.mylibrary.data.DefaultAppContainer

class LibraryApplication : Application() {

    lateinit var container: AppContainer

    override fun onCreate() {
        super.onCreate()
        container = DefaultAppContainer()
    }
}