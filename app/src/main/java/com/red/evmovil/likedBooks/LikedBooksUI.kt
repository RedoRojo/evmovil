package com.red.evmovil.likedBooks

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel

import androidx.lifecycle.viewmodel.compose.viewModel
@Composable
fun LikedBooksUI(onBack: () -> Unit) {
    val viewModel: LikedBooksViewModel = hiltViewModel()
    val likedBooks by viewModel.likedBooks.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.loadFavorites()
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Button(
            onClick = onBack,
            modifier = Modifier.padding(bottom = 16.dp)
        ) {
            Text("← Atras")
        }

        Text(
            text = "Los libros que te gustan son:",
            style = MaterialTheme.typography.headlineSmall,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(12.dp),
            modifier = Modifier.fillMaxSize()
        ) {
            items(likedBooks) { book ->
                Card(modifier = Modifier.fillMaxWidth()) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(12.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Column(modifier = Modifier.weight(1f)) {
                            Text("📚 ${book.title} (${book.publicationYear})", style = MaterialTheme.typography.titleMedium)
                            Text("Autores: ${book.authors.joinToString()}", style = MaterialTheme.typography.bodyMedium)
                        }

                        Icon(
                            imageVector = Icons.Default.Favorite,
                            contentDescription = "Favorito"
                        )
                    }
                }
            }
        }
    }
}