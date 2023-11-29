package com.example.android_basics

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.material3.Icon
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Phone
import androidx.compose.material.icons.rounded.Share
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
                   BusinessCard()
               }
            }
        }
    }
}


@Composable
fun BioDataAndImage() {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        val image = painterResource(id = R.drawable.android_logo)
        Image(
            painter = image,
            contentDescription = null,
            modifier = Modifier
                .width(100.dp)
                .height(100.dp)
        )
        Text(text = "Ifeanyichukwu Samuel", fontSize = 30.sp, fontWeight = FontWeight.Bold)
        Text(text = "Android Engineer Extraordinaire", textAlign = TextAlign.Justify, fontSize = 18.sp)
    }
}

@Composable
fun OtherDetailsWidget(
    icon: ImageVector,
    title: String,
    modifier: Modifier = Modifier
    ) {
    Row(
        verticalAlignment =  Alignment.CenterVertically,
        modifier = modifier.padding(bottom = 8.dp)
    ){
        Icon(icon, contentDescription = null, tint = Color(0xFF17C766))
        Spacer(modifier = Modifier.width(12.dp))
        Text(text = title, textAlign = TextAlign.Justify, fontSize = 18.sp)
    }
}

@Composable
fun ContactDetails(modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.Start,
        modifier = modifier.padding(bottom = 30.dp)
    ) {
        OtherDetailsWidget(icon = Icons.Rounded.Phone, title = "+234 813 946 0953")
        OtherDetailsWidget(icon = Icons.Rounded.Share, title = "@mkaychuks")
        OtherDetailsWidget(icon = Icons.Rounded.Email, title = "sachufusi@gmail.com")
    }
}

@Composable
fun BusinessCard() {
    Column(
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xEDBDCAC9))
    ) {
        Spacer(modifier = Modifier.height(100.dp))
        BioDataAndImage()
        ContactDetails()
    }
}

@Preview(showBackground = true)
@Composable
fun TaskManagerPreview() {
    Android_basicsTheme {
        BusinessCard()
    }
}