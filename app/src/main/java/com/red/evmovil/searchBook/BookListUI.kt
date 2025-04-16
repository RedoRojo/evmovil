package com.red.evmovil.searchBook

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material.icons.filled.Favorite
import com.red.domain.Book
import androidx.compose.material.icons.filled.FavoriteBorder
import com.red.evmovil.R

@Composable
fun BookListUI() {

    val viewModel: BookListViewModel = viewModel()

    var searchQuery by remember { mutableStateOf("") }
    val bookListState by viewModel.flow.collectAsState()
    val likedBooks = remember { mutableStateListOf<Book>() }

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        OutlinedTextField(
            value = searchQuery,
            onValueChange = { searchQuery = it },
            label = { Text("Bucar libro") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                viewModel.searchBook(searchQuery)
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Buscar")
        }

        Spacer(modifier = Modifier.height(16.dp))

        when(val state = bookListState) {
            is BookListViewModel.BookState.Init -> {
                Text(text = "Ingresa un titulo")
            }

            is BookListViewModel.BookState.Loading -> {
                CircularProgressIndicator()
            }
            is BookListViewModel.BookState.Success -> {
                LazyColumn(
                    verticalArrangement = Arrangement.spacedBy(16.dp),
                    modifier = Modifier.fillMaxSize()
                ) {
                    items(state.books) { book ->
                        Card(
                            modifier = Modifier.fillMaxSize()
                        ) {
                            Row(
                                modifier = Modifier.fillMaxSize().fillMaxWidth().padding(12.dp),
                                horizontalArrangement = Arrangement.SpaceBetween

                            ) {
                                Column(
                                    modifier = Modifier.weight(1f)
                                ) {
                                    Text(
                                        "📚 ${book.title} (${book.publicationYear})",
                                        style = MaterialTheme.typography.titleMedium
                                    )
                                    Text(
                                        "Autor/es: ${book.authors.joinToString()}",
                                        style = MaterialTheme.typography.bodyMedium
                                    )
                                }
                                val isLiked = likedBooks.contains(book)
                                IconButton(
                                    onClick = {
                                        if (isLiked) {
                                            likedBooks.remove(book)
                                        } else {
                                            viewModel.likeBook(book)
                                        }
                                    }) {
                                    Icon(
                                        imageVector = if (isLiked) Icons.Default.Favorite else Icons.Default.FavoriteBorder,
                                        contentDescription = if (isLiked) "No te gusta" else "Te gusta"
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }


    }
}