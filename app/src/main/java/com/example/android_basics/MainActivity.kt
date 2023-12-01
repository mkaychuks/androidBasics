package com.example.android_basics

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.android_basics.ui.theme.Android_basicsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Android_basicsTheme {
               Surface(
                   modifier = Modifier.fillMaxSize(),
                   color = MaterialTheme.colorScheme.background
               ) {
                   LemonadeApp()
               }
            }
        }
    }
}


@Composable
fun LemonadeApp() {
    var currentIndex by remember {
        mutableStateOf(1)
    }

    var squeezeIndex by remember {
        mutableStateOf(0)
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        val image = when(currentIndex){
            1 -> painterResource(id = R.drawable.lemon_tree)
            2 -> painterResource(id = R.drawable.lemon_squeeze)
            3 -> painterResource(id = R.drawable.lemon_drink)
            else -> painterResource(id = R.drawable.lemon_restart)
        }
        val description: String = when(currentIndex){
            1 -> "Tap the lemon tree to select a lemon"
            2 -> "Keep tapping the lemon to squeeze it"
            3 -> "Tap the lemonade to drink it"
            else -> "Tap the empty glass to start again"
        }

        when(currentIndex){
            2 -> Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Image(
                    painter = image,
                    contentDescription = null,
                    modifier = Modifier.clickable {
                        squeezeIndex -= 1
                        if(squeezeIndex == 0) currentIndex += 1
                    }
                )
                Spacer(modifier = Modifier.height(12.dp))
                Text(
                    text = description,
                    color = Color.Black
                )
            }
            else -> Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Image(
                    painter = image,
                    contentDescription = null,
                    modifier = Modifier.clickable {
                        currentIndex += 1
                        squeezeIndex = (2..4).random()
                        if(currentIndex == 5) currentIndex = 1
                    }
                )
                Spacer(modifier = Modifier.height(12.dp))
                Text(
                    text = description,
                    color = Color.Black
                )
            }
        }

    }
}



@Preview(showBackground = true)
@Composable
fun LemonadeAppPreview() {
    Android_basicsTheme {
        LemonadeApp()
    }
}