package com.example.composeecartapp

import com.example.composeecartapp.Products.Product
import com.example.composeecartapp.Products.ProductDao
import com.example.composeecartapp.Products.ProductRepository
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.verify
import org.mockito.kotlin.whenever

@RunWith(MockitoJUnitRunner::class)
class ProductRepositoryTest {

    @Mock
    lateinit var productDao: ProductDao

    @InjectMocks
    lateinit var productRepository: ProductRepository

    @Before
    fun setup() {
    }

    @Test
    fun testInsertProduct() = runBlocking {
        val product = Product(name = "Test Product", price = 50.0, imageUrl =  R.drawable.sample_one)

        // We simulate that the insert function of the DAO was called
        productRepository.insertAll(listOf(product))

        // Verify that insert was called with the correct product
        verify(productDao).insertAll(listOf(product))
    }

    @Test
    fun testGetAllProducts() = runBlocking {
        val productList = listOf(Product(name = "Test Product", price = 50.0, imageUrl = R.drawable.sample_two))

        // When calling getAllProducts, we want to return a mocked list
        whenever(productDao.getAllProducts()).thenReturn(productList)

        // Now we call the repository method and verify the result
        val result = productRepository.getAllProducts()

        assertEquals(productList, result)  // Assert that the result matches
    }

    @Test
    fun testDeleteProduct() = runBlocking {
        val product = Product(name = "Test Product", price = 50.0, imageUrl = R.drawable.sample_two)
        productRepository.deleteProduct(product)
        verify(productDao).deleteProduct(product)
    }

}