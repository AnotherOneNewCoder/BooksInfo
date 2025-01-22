package ru.zhogin.book.domain

import kotlinx.coroutines.flow.Flow
import ru.zhogin.core.domain.DataError
import ru.zhogin.core.domain.EmptyResult
import ru.zhogin.core.domain.Result

interface BookRepository {
    suspend fun searchBooks(query: String): Result<List<Book>, DataError.Remote>
    suspend fun getBooDescription(bookId: String): Result<String?, DataError>

    fun getFavoriteBooks(): Flow<List<Book>>
    fun isBookFavorite(id: String): Flow<Boolean>

    suspend fun toMarkAsFavorite(book: Book): EmptyResult<DataError.Local>
    suspend fun deleteFromFavorite(id: String)
}