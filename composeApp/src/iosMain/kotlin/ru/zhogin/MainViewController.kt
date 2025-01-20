package ru.zhogin

import androidx.compose.ui.window.ComposeUIViewController
import ru.zhogin.book.app.App
import ru.zhogin.di.initKoin

fun MainViewController() = ComposeUIViewController(
    configure = {
        initKoin()
    }
) { App() }