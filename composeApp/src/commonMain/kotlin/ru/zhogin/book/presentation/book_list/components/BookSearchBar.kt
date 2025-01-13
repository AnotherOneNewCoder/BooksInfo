package ru.zhogin.book.presentation.book_list.components

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import booksinfo.composeapp.generated.resources.Res
import booksinfo.composeapp.generated.resources.search_hint
import org.jetbrains.compose.resources.stringResource
import ru.zhogin.core.presentation.DarkBlue
import ru.zhogin.core.presentation.SandYellow

@Composable
fun BookSearchBar(
    searchQuery: String,
    onSearchQueryChange: (String) -> Unit,
    onImeSearch: () -> Unit,
    modifier: Modifier = Modifier,
) {
    OutlinedTextField(
        value = searchQuery,
        onValueChange = onSearchQueryChange,
        shape = RoundedCornerShape(100),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            cursorColor = DarkBlue,
            focusedBorderColor = SandYellow,
        ),
        placeholder = {
            Text(
                text = stringResource(Res.string.search_hint)
            )
        }
    )
}