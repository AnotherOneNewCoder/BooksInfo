package ru.zhogin.book.presentation.book_list

import ru.zhogin.book.domain.Book
import ru.zhogin.core.presentation.UiText

data class BookListState(
    val searchQuery: String = "Kotlin",
 //   val searchResults: List<Book> = emptyList(),
    val searchResults: List<Book> = books,
    val favouriteBooks: List<Book> = emptyList(),
    val isLoading: Boolean = false,
    val selectedTabIndex: Int = 0,
    val errorMessage: UiText? = null,
)

private val books = (1..100).map {
    Book(
        id = it.toString(),
        title = "Book $it",
        imageUrl = "https://test.com",
        authors = listOf("Ivan Zhogin"),
        description = "Description $it",
        languages = emptyList(),
        firstPublishYear = null,
        averageRating = 4.67665,
        ratingCount = 5,
        numPages = 100,
        numEditions = 3
    )
}
