package com.example.composeecartapp.Authentication

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(private val repository: UserRepository) : ViewModel(){
    private val _loginResult = MutableLiveData<Boolean>()
    val loginResult : LiveData<Boolean> = _loginResult

    private val _registrationResult = MutableLiveData<Boolean>()
    val registrationResult :LiveData<Boolean> = _registrationResult

    fun login(username: String, password : String){
        viewModelScope.launch {
           val user = repository.getUserByUsername(username)
            _loginResult.value = user != null && user.password == password
        }
    }

    fun registration(username: String, password: String){
        viewModelScope.launch {
            if(!repository.checkUserExist(username)){
                val user = User(userName = username, password = password)
                repository.insertUser(user)
                _registrationResult.value = true
            } else{
               _registrationResult.value = false
            }
        }
    }
}