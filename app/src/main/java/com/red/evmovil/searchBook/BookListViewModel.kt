package com.red.evmovil.searchBook;

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.red.domain.Book
import com.red.usecases.SearchBook
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BookListViewModel @Inject constructor(
    private val searchBook: SearchBook
) : ViewModel() {
    private val _listState = MutableStateFlow<List<Book>>(emptyList())
    val listState: StateFlow<List<Book>> = _listState
    fun searchBook(toSearch: String) {
        _listState.value = searchBook.invoke(toSearch)
    }
}
