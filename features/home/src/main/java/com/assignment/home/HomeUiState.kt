package com.assignment.home

import com.assignment.domain.models.RandomResult


data class HomeUiState(
    val users: List<RandomResult> = emptyList(),
    val isLoading: Boolean = false
)