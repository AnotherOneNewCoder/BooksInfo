package ru.zhogin.book.data.network

import ru.zhogin.book.data.dto.SearchResponseDto
import ru.zhogin.core.domain.DataError
import ru.zhogin.core.domain.Result

interface RemoteBookDataSource {
    suspend fun searchBooks(
        query: String,
        resultLimit: Int? = null,
    ) : Result<SearchResponseDto, DataError.Remote>
}