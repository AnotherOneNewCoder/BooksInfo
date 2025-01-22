package ru.zhogin.book.data.repository

import kotlinx.coroutines.flow.Flow
import ru.zhogin.book.data.mappers.toBook
import ru.zhogin.book.data.network.RemoteBookDataSource
import ru.zhogin.book.domain.Book
import ru.zhogin.book.domain.BookRepository
import ru.zhogin.core.domain.DataError
import ru.zhogin.core.domain.EmptyResult
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

    override suspend fun getBooDescription(bookId: String): Result<String?, DataError> {
        return remoteBookDataSource
            .getBookDetails(bookId)
            .map { it.description }
    }

    override fun getFavoriteBooks(): Flow<List<Book>> {
        TODO("Not yet implemented")
    }

    override fun isBookFavorite(id: String): Flow<Boolean> {
        TODO("Not yet implemented")
    }

    override suspend fun toMarkAsFavorite(book: Book): EmptyResult<DataError.Local> {
        TODO("Not yet implemented")
    }

    override suspend fun deleteFromFavorite(id: String) {
        TODO("Not yet implemented")
    }
}