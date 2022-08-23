package com.example.android4lesson3.ui.screens.model

import androidx.compose.runtime.Stable

sealed class ClickEvent {
    object FirstClick: ClickEvent()
    object SecondClick: ClickEvent()
    object ThirdClick: ClickEvent()
}

@Stable
data class CounterViewState(
    val firstCount: Int = 0,
    val secondCount: Int = 0,
    val thirdCount: Int = 0
)
