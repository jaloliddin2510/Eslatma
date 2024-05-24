package com.example.eslatma.Options

import android.app.Application

class NoteApp:Application() {
    companion object{
        lateinit var appDataBase: AppDataBase
    }

    override fun onCreate() {
        super.onCreate()
        appDataBase=AppDataBase.getInstance(this)
    }
}