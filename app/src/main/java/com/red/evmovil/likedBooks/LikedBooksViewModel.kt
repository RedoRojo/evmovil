package com.red.evmovil.likedBooks

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.red.domain.Book
import com.red.usecases.GetLikedBooks
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LikedBooksViewModel @Inject constructor(
    private val getLikedBooks: GetLikedBooks
) : ViewModel() {

    private val _likedBooks = MutableStateFlow<List<Book>>(emptyList())
    val likedBooks: StateFlow<List<Book>> = _likedBooks

    fun loadFavorites() {
        viewModelScope.launch {
            _likedBooks.value = getLikedBooks.invoke()
        }
    }
}
