package com.red.evmovil.searchBook;

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.red.domain.Book
import com.red.usecases.LikeBook
import com.red.usecases.SearchBook
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class BookListViewModel @Inject constructor(
    private val searchBook: SearchBook,
    private val likeBook: LikeBook
) : ViewModel() {

    sealed class BookState {
        object Loading : BookState()
        class Success(val books: List<Book>) : BookState()
        object Init : BookState()
    }

    private val _flow = MutableStateFlow<BookState>(BookState.Init)
    val flow: StateFlow<BookState> = _flow

    fun searchBook(title: String) {
        viewModelScope.launch {
            _flow.value = BookState.Loading
            val result = searchBook.invoke(title)
            val books = result.distinctBy { it.title to it.authors.joinToString() }
            _flow.value = BookState.Success(books)
        }
    }

    fun likeBook(book: Book) {
        viewModelScope.launch {
            likeBook.invoke(book)
        }
    }
}
