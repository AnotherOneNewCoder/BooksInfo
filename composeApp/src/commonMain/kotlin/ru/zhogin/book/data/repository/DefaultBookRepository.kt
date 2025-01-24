package ru.zhogin.book.data.repository

import androidx.sqlite.SQLiteException
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import ru.zhogin.book.data.database.FavoriteBookDao
import ru.zhogin.book.data.mappers.toBook
import ru.zhogin.book.data.mappers.toBookEntity
import ru.zhogin.book.data.network.RemoteBookDataSource
import ru.zhogin.book.domain.Book
import ru.zhogin.book.domain.BookRepository
import ru.zhogin.core.domain.DataError
import ru.zhogin.core.domain.EmptyResult
import ru.zhogin.core.domain.Result
import ru.zhogin.core.domain.map

class DefaultBookRepository(
    private val remoteBookDataSource: RemoteBookDataSource,
    private val favoriteBookDao: FavoriteBookDao,
) : BookRepository {
    override suspend fun searchBooks(query: String) : Result<List<Book>, DataError.Remote> {
        return remoteBookDataSource
            .searchBooks(query)
            .map { dto ->
                dto.results.map { it.toBook() }
            }
    }

    override suspend fun getBooDescription(bookId: String): Result<String?, DataError> {
        val localResult = favoriteBookDao.getFavoriteBook(bookId)
        return if (localResult == null) {
            remoteBookDataSource
                .getBookDetails(bookId)
                .map { it.description }
        } else {
            Result.Success(localResult.description)
        }
    }

    override fun getFavoriteBooks(): Flow<List<Book>> {
        return favoriteBookDao
            .getFavoriteBooks()
            .map { bookEntities->
                bookEntities.map { it.toBook() }
            }
    }

    override fun isBookFavorite(id: String): Flow<Boolean> {
        return favoriteBookDao
            .getFavoriteBooks()
            .map { bookEntities ->
                bookEntities.any { it.id == id }
            }
    }

    override suspend fun toMarkAsFavorite(book: Book): EmptyResult<DataError.Local> {
        return try {
            favoriteBookDao.upsert(book.toBookEntity())
            Result.Success(Unit)
        } catch (e: SQLiteException) {
            Result.Error(DataError.Local.DISK_FULL)
        }
    }

    override suspend fun deleteFromFavorite(id: String) {
        favoriteBookDao.deleteFavoriteBook(id)
    }
}