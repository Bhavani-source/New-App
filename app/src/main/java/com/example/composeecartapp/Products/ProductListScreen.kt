package com.example.composeecartapp.Products

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.composeecartapp.R

@Composable
fun ProductListScreen(viewModel: ProductViewModel = hiltViewModel(), onNavigateToHome: () ->Unit) {
    val products by viewModel.products.observeAsState(listOf())
    val context = LocalContext.current

    LazyColumn {
        items(products) { product ->
            ProductItem(product, onDelete = { viewModel.deleteProduct(product) })
        }
    }

    // Add button to add new product (Just for illustration)
    Button(onClick = {

        val items = listOf(
            Product(name = "Product 1", price = 10.0, imageUrl = R.drawable.sample_one),
            Product(name = "Product 2", price = 20.0, imageUrl = R.drawable.sample_two),
            Product(name = "Product 3", price = 30.0, imageUrl = R  .drawable.sample_four),
            Product(name = "Product 4", price = 10.0, imageUrl = R.drawable.sample_one),
            Product(name = "Product 5", price = 20.0, imageUrl = R.drawable.sample_two),
            Product(name = "Product 6", price = 30.0, imageUrl = R  .drawable.sample_four)
        )

        viewModel.addProduct(items)
    }) {
        Text("Add Product")
    }
}

@Composable
fun ProductItem(product: Product, onDelete: () -> Unit) {
    Row(
        modifier = Modifier.fillMaxWidth().padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = product.name)
        Text(text = "$${product.price}")
        IconButton(onClick = onDelete) {
            Icon(imageVector = Icons.Default.Delete, contentDescription = "Delete")
        }
    }
}
