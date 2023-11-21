package com.example.android_basics

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    var backgroundColor by mutableStateOf(Color.White)
        private set

    // change background color
    fun changeBackgroundColor(){
        backgroundColor = Color.Magenta
    }
}