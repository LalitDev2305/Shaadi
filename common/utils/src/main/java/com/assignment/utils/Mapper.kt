package com.assignment.utils

interface Mapper<F, T> {
    fun map(from: F): T
}
