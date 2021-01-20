package me.alberto.a3line.screens.details.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import me.alberto.a3line.data.domain.model.User
import me.alberto.a3line.data.domain.repository.IRepository
import javax.inject.Inject

class DetailsViewModel @Inject constructor(private val repository: IRepository) : ViewModel() {
    private val _message = MutableLiveData<String>()
    val message: LiveData<String> = _message
    fun updateUser(user: User) {
        viewModelScope.launch {
            try {
                repository.updateUser(user)
                _message.postValue("Profile updated")
            } catch (exp: Exception) {
                _message.postValue("An error occurred")
                exp.printStackTrace()
            }
        }
    }
}