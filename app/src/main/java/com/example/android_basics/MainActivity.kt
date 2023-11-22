package com.example.android_basics

import android.content.ActivityNotFoundException
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.android_basics.ui.theme.Android_basicsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Android_basicsTheme {
               Column (
                   modifier = Modifier.fillMaxSize(),
                   verticalArrangement = Arrangement.Center,
                   horizontalAlignment = Alignment.CenterHorizontally
               ){
                   Button(onClick = {
//                        OPENING AN EXTERNAL APP, EXPLICIT INTENT
                       Intent(Intent.ACTION_MAIN).also {
                           it.`package` = "com.google.android.youtube"
                           try {
                               startActivity(it)
                           } catch (e: ActivityNotFoundException){
                               println(e)
                           }
                       }
                   }) {
                       Text(text = "Open Youtube")
                   }
                   Spacer(modifier = Modifier.height(30.dp))
                   Button(onClick = {
                       // IMPLICIT INTENT
                       val intent = Intent(Intent.ACTION_SEND).apply{
                           type = "text/plain"
                           putExtra(Intent.EXTRA_TEXT, "This is the body of the mail")
                       }
                       if(intent.resolveActivity(packageManager) != null){
                           startActivity(intent)
                       }

                       Intent()
                   }) {
                       Text(text = "Send a message")
                   }
               }

            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Android_basicsTheme {
        Greeting("Android")
    }
}