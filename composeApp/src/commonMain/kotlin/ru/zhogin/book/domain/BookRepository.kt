package ru.zhogin.book.domain

import ru.zhogin.core.domain.DataError
import ru.zhogin.core.domain.Result

interface BookRepository {
    suspend fun searchBooks(query: String): Result<List<Book>, DataError.Remote>
}