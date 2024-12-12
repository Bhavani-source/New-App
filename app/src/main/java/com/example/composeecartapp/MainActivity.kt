package com.example.composeecartapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.example.composeecartapp.Authentication.LoginScreen
import com.example.composeecartapp.Authentication.RegistrationScreen
import com.example.composeecartapp.Products.ProductListScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            var isLoggedIn by remember { mutableStateOf(false) }
            var isRegistred by remember { mutableStateOf(false) }

            if (isLoggedIn) {
                // Navigate to eCart functionality
                LoginScreen(onNavigateToProduct = { isLoggedIn = true })
            } else {
                //Navigate to Registration screen
                RegistrationScreen(onNavigateToLogin = { isRegistred = true })
            }
        }
    }
}

