package com.example.android4lesson3.ui.screens

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.android4lesson3.common.EventHandler
import com.example.android4lesson3.ui.screens.model.ClickEvent
import com.example.android4lesson3.ui.screens.model.CounterViewState
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking

class CounterViewModel : ViewModel(), EventHandler<ClickEvent> {
    private val _viewState = MutableLiveData(CounterViewState())
    val viewState: LiveData<CounterViewState> = _viewState

    override fun obtainEvent(event: ClickEvent) = runBlocking {
        when (event) {
            ClickEvent.FirstClick -> {
                val newValue: Flow<Int?> = flowOf(viewState.value?.firstCount)
                newValue.map { _value -> _value?.plus(1) }
                    .collect{ _value ->
                    _viewState.postValue(_viewState.value?.copy(firstCount = _value))
                }
            }

            ClickEvent.SecondClick -> {
                val newValue: Flow<Int?> = flowOf(viewState.value?.secondCount)
                newValue.map { _value -> _value?.plus(1) }
                    .collect{ _value ->
                        _viewState.postValue(_viewState.value?.copy(secondCount = _value))
                    }
            }

            ClickEvent.ThirdClick -> {
                val newValue: Flow<Int?> = flowOf(viewState.value?.thirdCount)
                newValue.map { _value -> _value?.plus(1) }
                    .collect{ _value ->
                        _viewState.postValue(_viewState.value?.copy(thirdCount = _value))
                    }
            }
        }
    }
}