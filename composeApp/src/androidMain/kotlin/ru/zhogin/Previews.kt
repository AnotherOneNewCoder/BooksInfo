package ru.zhogin

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import ru.zhogin.book.domain.Book
import ru.zhogin.book.presentation.book_list.BookListScreen
import ru.zhogin.book.presentation.book_list.BookListState
import ru.zhogin.book.presentation.book_list.components.BookSearchBar

@Preview
@Composable
private fun BookSearchBarPreview() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
    ) {
        BookSearchBar(
            searchQuery = "",
            onSearchQueryChange = {},
            onImeSearch = {},
            modifier = Modifier
                .fillMaxWidth()
        )
    }

}

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

@Preview
@Composable
private fun BookListScreenPreview() {
    BookListScreen(
        state = BookListState(
            searchResults = books
        ),
        onAction = {}
    )
}

