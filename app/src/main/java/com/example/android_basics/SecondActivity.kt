package com.example.android_basics

import android.os.Bundle
import android.os.PersistableBundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Text
import com.example.android_basics.ui.theme.Android_basicsTheme

class SecondActivity: ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        println("OnCreate of secondActivity")
        super.onCreate(savedInstanceState)
        setContent {
            Android_basicsTheme {
                Text(text = "SecondActivity")
            }
        }
    }
    override fun onStart() {
        super.onStart()
        println("onStart of secondActivity")
    }

    override fun onResume() {
        super.onResume()
        println("OnResume of secondActivity")
    }
}