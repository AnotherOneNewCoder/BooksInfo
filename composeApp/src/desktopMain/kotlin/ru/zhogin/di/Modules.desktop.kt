package ru.zhogin.di

import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.engine.okhttp.OkHttp
import org.koin.core.module.Module
import org.koin.dsl.module
import ru.zhogin.book.data.database.DatabaseFactory

actual val platformModel: Module
    get() = module {
        single<HttpClientEngine> { OkHttp.create() }
        single { DatabaseFactory() }
    }