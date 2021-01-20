package me.alberto.a3line.screens.home.viewmodel

import android.util.Log
import androidx.lifecycle.*
import kotlinx.coroutines.launch
import me.alberto.a3line.data.domain.repository.IRepository
import me.alberto.a3line.data.local.database.UserEntity
import me.alberto.a3line.util.State
import me.alberto.a3line.util.State.*
import me.alberto.a3line.util.helper.NetworkHelper
import javax.inject.Inject

class HomeViewModel @Inject constructor(
    private val repository: IRepository,
    private val networkHelper: NetworkHelper
) :
    ViewModel() {

    private val TAG = "HomeViewModel"
    val users = repository.getUsers()
    private val usersObserver = Observer<List<UserEntity>> { observeUsers(it) }
    private val _state = MutableLiveData<State>()
    val state: LiveData<State> = _state

    init {
        users.observeForever(usersObserver)
    }


    private fun observeUsers(users: List<UserEntity>) {
        if (users.isEmpty()) getRemote()
        Log.d(TAG, "${users.size}")
    }

    private fun getRemote() {
        if (!networkHelper.isConnected()) {
            _state.postValue(Error("You're offline"))
            return
        }
        _state.postValue(Loading)
        viewModelScope.launch {
            try {
                repository.getRemote()
                _state.postValue(Done)
            } catch (exp: Exception) {
                exp.printStackTrace()
                _state.postValue(Error(exp.message ?: "Some error occurred"))
            }
        }
    }


    override fun onCleared() {
        users.removeObserver(usersObserver)
        super.onCleared()
    }

}