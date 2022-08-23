package com.example.android4lesson3.common

interface EventHandler<E> {
    fun obtainEvent(event: E)
}