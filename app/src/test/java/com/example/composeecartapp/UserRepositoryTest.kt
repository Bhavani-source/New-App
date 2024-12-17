package com.example.composeecartapp

import com.example.composeecartapp.Products.ProductDao
import com.example.composeecartapp.Products.ProductRepository
import org.junit.Before
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class UserRepositoryTest  {
    @Mock
    lateinit var productDao: ProductDao

    @InjectMocks
    lateinit var productRepository: ProductRepository

    @Before
    fun setup() {
    }
}