package com.example.android_basics

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
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
//                       Intent(applicationContext, SecondActivity::class.java).also {
//                           startActivity(it)
//                       }
//                       Intent(Intent.ACTION_MAIN).also {
//                           it.`package` = "com.google.android.youtube"
//                           try {
//                               startActivity(it)
//                           } catch (e: ActivityNotFoundException) {
//                               e.printStackTrace()
//                           }
//                       }
                       val intent = Intent(Intent.ACTION_SEND).apply {
                           type = "text/plain"
                           putExtra(Intent.EXTRA_EMAIL, arrayOf("viktorachufusi@gmail.com", "jachufusi@gmail.com", "achufusik@gmail.com"))
                           putExtra(Intent.EXTRA_SUBJECT, "THIS IS A TEST EMAIL CLIENT")
                           putExtra(Intent.EXTRA_TEXT, "This mail is coming from Ifeanyi and it is a test email, so do not panic of spam of what have you :grin:")
                       }
                        if(intent.resolveActivity(packageManager) != null){
                            startActivity(intent)
                        }
                   }) {
                       Text(text = "Click Me")
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