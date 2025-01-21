package ru.zhogin.book.presentation.book_detail

import ru.zhogin.book.domain.Book

data class BookDetailState(
    val isLoading: Boolean = true,
    val isFavourite: Boolean = false,
    val book: Book? = null
)
