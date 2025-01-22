package ru.zhogin.book.presentation.book_detail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.toRoute
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import ru.zhogin.book.app.Route
import ru.zhogin.book.domain.BookRepository
import ru.zhogin.core.domain.onSuccess

class BookDetailViewModel(
    private val bookRepository: BookRepository,
    savedStateHandle: SavedStateHandle,
): ViewModel() {
    private val bookId = savedStateHandle.toRoute<Route.BookDetail>().id
    private val _state = MutableStateFlow(BookDetailState())
    val state = _state
        .onStart {
            fetchBookDescription()
        }
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000L), _state.value)

    fun onAction(action: BookDetailAction) {
        when(action) {
            is BookDetailAction.OnFavoriteClick -> {

            }
            is BookDetailAction.OnSelectedBookChange -> {
                _state.update { it.copy(
                    book = action.book
                ) }
            }
            else -> Unit
        }
    }
    private fun fetchBookDescription() {
        viewModelScope.launch {
            bookRepository
                .getBooDescription(bookId)
                .onSuccess { description ->
                    _state.update { it.copy(
                        book = it.book?.copy(
                            description = description
                        ),
                        isLoading = false
                    ) }
                }
        }
    }
}