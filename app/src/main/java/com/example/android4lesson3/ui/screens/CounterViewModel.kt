package com.example.android4lesson3.ui.screens

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.android4lesson3.common.EventHandler
import com.example.android4lesson3.ui.screens.model.ClickEvent
import com.example.android4lesson3.ui.screens.model.CounterViewState

class CounterViewModel : ViewModel(), EventHandler<ClickEvent> {
    private val _viewState = MutableLiveData(CounterViewState())
    val viewState: LiveData<CounterViewState> = _viewState

    override fun obtainEvent(event: ClickEvent) {
        when (event) {
            ClickEvent.FirstClick -> _viewState.postValue(
                _viewState.value?.firstCount?.plus(
                    1
                )?.let { _viewState.value?.copy(firstCount = it) })

            ClickEvent.SecondClick -> _viewState.postValue(
                _viewState.value?.secondCount?.plus(
                    1
                )?.let { _viewState.value?.copy(secondCount = it) })

            ClickEvent.ThirdClick -> _viewState.postValue(
                _viewState.value?.thirdCount?.plus(1)
                    ?.let { _viewState.value?.copy(thirdCount = it) })
        }
    }
}