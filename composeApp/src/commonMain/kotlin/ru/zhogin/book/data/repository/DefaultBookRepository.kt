package ru.zhogin.book.data.repository

import ru.zhogin.book.data.mapprs.toBook
import ru.zhogin.book.data.network.RemoteBookDataSource
import ru.zhogin.book.domain.Book
import ru.zhogin.book.domain.BookRepository
import ru.zhogin.core.domain.DataError
import ru.zhogin.core.domain.Result
import ru.zhogin.core.domain.map

class DefaultBookRepository(
    private val remoteBookDataSource: RemoteBookDataSource
) : BookRepository {
    override suspend fun searchBooks(query: String) : Result<List<Book>, DataError.Remote> {
        return remoteBookDataSource
            .searchBooks(query)
            .map { dto ->
                dto.results.map { it.toBook() }
            }
    }
}