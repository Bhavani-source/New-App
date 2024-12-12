package com.example.composeecartapp.Authentication

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.motionEventSpy
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun RegistrationScreen(viewModel: AuthViewModel = hiltViewModel(),onNavigateToLogin: () ->Unit){

    var userName by remember { mutableStateOf(" ") }
    var password by remember { mutableStateOf(" ") }
    var confirmationpassword by remember { mutableStateOf(" ") }
    val registrationResult by viewModel.registrationResult.observeAsState()

    Column (modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)) {
        Text("Register", style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(16.dp))


        OutlinedTextField(
            value = userName,
            onValueChange = { userName = it },
            label = { Text("username") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(Modifier.height(8.dp))
        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("password") },
            modifier = Modifier.fillMaxWidth(),
            visualTransformation = PasswordVisualTransformation()
        )
        Spacer(Modifier.height(8.dp))
        OutlinedTextField(
            value = password,
            onValueChange = { confirmationpassword = it },
            label = { Text("confirmationpassword") },
            modifier = Modifier.fillMaxWidth(),
            visualTransformation = PasswordVisualTransformation()
        )

        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = {
                if (password == confirmationpassword) {
                    viewModel.registration(userName, password)
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("register")
        }
        Spacer(modifier = Modifier.height(8.dp))

        registrationResult?.let {
            if (it) {
                Text("onRegistration successfull", color = Color.Green)
                onNavigateToLogin()
            } else {
                Text("User Already exist", color = Color.Red)
            }
        }

        Spacer(Modifier.height(16.dp))
        TextButton(onClick = onNavigateToLogin) {
           Text("already have a account")
        }
    }
}