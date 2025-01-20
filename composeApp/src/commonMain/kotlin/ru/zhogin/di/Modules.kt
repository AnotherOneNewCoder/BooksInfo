package ru.zhogin.di

import org.koin.core.module.Module
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.bind
import org.koin.dsl.module
import ru.zhogin.book.data.network.KtorRemoteBookDataSource
import ru.zhogin.book.data.network.RemoteBookDataSource
import ru.zhogin.book.data.repository.DefaultBookRepository
import ru.zhogin.book.domain.BookRepository
import ru.zhogin.book.presentation.book_list.BookListViewModel
import ru.zhogin.core.data.HttpClientFactory

expect val platformModel: Module

val sharedModule = module {
    single {
        HttpClientFactory.create(get())
    }
    singleOf(::KtorRemoteBookDataSource).bind<RemoteBookDataSource>()
    singleOf(::DefaultBookRepository).bind<BookRepository>()

    viewModelOf(::BookListViewModel)
}