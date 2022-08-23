package com.example.android4lesson3.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.android4lesson3.ui.screens.model.ClickEvent
import com.example.android4lesson3.ui.screens.model.CounterViewState

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MainScreen(viewModel: CounterViewModel) {

    val viewState = viewModel.viewState.observeAsState(CounterViewState())

    Scaffold(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp)
        ) {
            Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
                Text(text = viewState.value.firstCount.toString())
            }
            Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
                Button(onClick = { viewModel.obtainEvent(ClickEvent.FirstClick) }) {
                    Text(text = "Значение 1")
                }
            }
            Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
                Text(text = viewState.value.secondCount.toString())}
            Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
                Button(onClick = { viewModel.obtainEvent(ClickEvent.SecondClick) }) {
                    Text(text = "Значение 2")
                }
            }
            Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
                Text(text = viewState.value.thirdCount.toString())}
            Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
                Button(onClick = { viewModel.obtainEvent(ClickEvent.ThirdClick) }) {
                    Text(text = "Значение 3")
                }
            }
        }
    }
}