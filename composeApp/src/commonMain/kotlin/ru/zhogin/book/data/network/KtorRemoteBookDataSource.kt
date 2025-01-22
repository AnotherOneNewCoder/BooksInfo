package ru.zhogin.book.data.network

import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import ru.zhogin.book.data.dto.BookWorkDto
import ru.zhogin.book.data.dto.SearchResponseDto
import ru.zhogin.core.data.safeCall
import ru.zhogin.core.domain.DataError
import ru.zhogin.core.domain.Result

private const val BASE_URL = "https://openlibrary.org"

class KtorRemoteBookDataSource(
    private val httpClient: HttpClient
): RemoteBookDataSource {
    override suspend fun searchBooks(
        query: String,
        resultLimit: Int?
    ): Result<SearchResponseDto, DataError.Remote>
    {
        return safeCall<SearchResponseDto> {
            httpClient.get(
                urlString = "$BASE_URL/search.json"
            ) {
                parameter("q", query)
                parameter("limit", resultLimit)
                parameter("language", "eng")
                parameter(
                    "fields",
                    "key,title, language, cover_i, author_key, author_name, cover_edition_key, first_publish_year, ratings_average, ratings_count, number_of_pages_median, edition_count"
                )
            }
        }
    }

    override suspend fun getBookDetails(bookWorkId: String): Result<BookWorkDto, DataError.Remote> {
        return safeCall<BookWorkDto> {
            httpClient.get(
                urlString = "$BASE_URL/works/$bookWorkId.json"
            )
        }
    }
}