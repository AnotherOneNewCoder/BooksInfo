package ru.zhogin.di

import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.engine.okhttp.OkHttp
import org.koin.core.module.Module
import org.koin.dsl.module

actual val platformModel: Module
    get() = module {
        single<HttpClientEngine> { OkHttp.create() }
    }