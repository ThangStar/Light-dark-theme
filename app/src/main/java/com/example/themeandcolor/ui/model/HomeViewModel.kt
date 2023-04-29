package com.example.themeandcolor.ui.model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.themeandcolor.room.column.User
import com.example.themeandcolor.room.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    val userRepository: UserRepository,
) : ViewModel() {
    private val _listUser = MutableStateFlow<List<User>>(emptyList())
    val listUser
        get() = _listUser.asStateFlow()

    init {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                initData()
            }
        }
    }

    fun handleAddUser() {
        viewModelScope.launch {
            val jobAdd = launch {
                withContext(Dispatchers.IO) {
                    userRepository.insert(User(null, "user count", 12, 1.7f))
                    initData()
                }
            }
        }

    }

    suspend fun initData() {
        _listUser.value = userRepository.getAll()
    }
}