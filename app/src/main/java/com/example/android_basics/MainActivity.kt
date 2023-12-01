package com.example.android_basics

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
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
                    DiceRoller()
               }
            }
        }
    }
}

@Composable
fun DiceRoller() {
    var sideUp by remember {
        mutableStateOf(1)
    }
   Column(
       modifier = Modifier
           .fillMaxSize()
           .background(Color.White),
       horizontalAlignment = Alignment.CenterHorizontally,
       verticalArrangement = Arrangement.Center
   ) {
       val diceImage = when(sideUp){
           1 -> painterResource(id = R.drawable.dice_1)
           2 -> painterResource(id = R.drawable.dice_2)
           3 -> painterResource(id = R.drawable.dice_3)
           4 -> painterResource(id = R.drawable.dice_4)
           5 -> painterResource(id = R.drawable.dice_5)
           else -> painterResource(id = R.drawable.dice_6)
       }
       Image(painter = diceImage, contentDescription = null)
       Button(
           onClick = {
               sideUp = (1..6).random()
           }
       ) {
           Text(text = "Roll the Dice")
       }
   } 
}



@Preview(showBackground = true)
@Composable
fun LemonadeAppPreview() {
    Android_basicsTheme {
        DiceRoller()
    }
}