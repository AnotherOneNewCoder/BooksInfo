package ru.zhogin.book.data.mapprs

import ru.zhogin.book.data.dto.SearchedBookDto
import ru.zhogin.book.domain.Book

fun SearchedBookDto.toBook(): Book {
    return Book(
        id = id,
        title = title,
        imageUrl = if (coverKey != null) {
            "https//covers.openlibrary.org/b/olid/${coverKey}-L.jpg"
        }
        else {
            "https//covers.openlibrary.org/b/olid/${coverAlternativeKey}-L.jpg"
        },
        authors = authorNames ?: emptyList(),
        description = null,
        languages = languages ?: emptyList(),
        firstPublishYear = firstPublishYear.toString(),
        averageRating = ratingsAverage,
        ratingCount = ratingsCount,
        numPages = numPagesMedian,
        numEditions = numEditions ?: 0,
    )
}