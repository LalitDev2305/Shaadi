package com.assignment.home

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.assignment.domain.RandomUsersUseCase
import com.assignment.domain.models.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val useCase: RandomUsersUseCase,
) : ViewModel() {

    private val _uiState = MutableStateFlow(HomeUiState())
    val uiState: StateFlow<HomeUiState> = _uiState

    init {
        getRandomUsers()
    }

    private fun getRandomUsers() = viewModelScope.launch {

        viewModelScope.launch {
            useCase.getUsersFromDb().collect { users ->
                if (users.isNotEmpty()) {
                    _uiState.value = HomeUiState(users = users, isLoading = false)
                } else {
                    // No users in DB, call API and insert
                    _uiState.value = HomeUiState(users = emptyList(), isLoading = true)

                    when (val result = useCase.invoke()) {
                        is Resource.Success -> {
                            _uiState.value = HomeUiState(users = result.result, isLoading = false)
                        }

                        is Resource.Error -> {
                            _uiState.value = HomeUiState(users = emptyList(), isLoading = false)
                        }
                    }
                }
            }
        }
    }

    fun updateUserStatus(userId: String, status: String) {
        viewModelScope.launch {
            Log.d("HomeViewModel", "updateUserStatus : $status")
            useCase(userId, status)
        }
    }
}