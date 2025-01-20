package ru.zhogin

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import ru.zhogin.book.app.App
import ru.zhogin.di.initKoin

fun main() {
    initKoin()
    application {
        Window(
            onCloseRequest = ::exitApplication,
            title = "BooksInfo",
        ) {
            App()
        }
    }
}