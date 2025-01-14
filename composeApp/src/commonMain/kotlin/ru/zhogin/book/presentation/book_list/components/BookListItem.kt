package ru.zhogin.book.presentation.book_list.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ru.zhogin.book.domain.Book
import ru.zhogin.core.presentation.LightBlue

@Composable
fun BookListItem(
    book: Book,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Surface(
        shape = RoundedCornerShape(32.dp),
        modifier = modifier
            .clickable(
                onClick = onClick
            ),
        color = LightBlue.copy(
            alpha = 0.2f
        )
    ) {

    }
}