package ru.zhogin

import android.app.Application
import org.koin.android.ext.koin.androidContext
import ru.zhogin.di.initKoin

class BookApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin {
            androidContext(this@BookApplication)
        }
    }
}