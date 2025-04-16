package com.red.evmovil.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun HomeUI(
    onGoToSearch: () -> Unit,
    onGoToLiked: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(32.dp),
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        Text(
            text = "Busca conocimiento",
            style = MaterialTheme.typography.headlineMedium
        )

        Button(onClick = onGoToSearch) {
            Text("Buscar libros")
        }

        Button(onClick = onGoToLiked) {
            Text("Mi gustados")
        }
    }
}