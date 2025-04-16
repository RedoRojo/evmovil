package com.red.evmovil.searchBook

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.red.evmovil.R

@Composable
fun BookListUI() {

    val viewModel: BookListViewModel = viewModel()

    var searchQuery by remember { mutableStateOf("") }
    val bookListState by viewModel.flow.collectAsState()

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
                            Column(
                                modifier = Modifier.padding(12.dp)
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
                        }
                    }
                }
            }
        }


    }
}