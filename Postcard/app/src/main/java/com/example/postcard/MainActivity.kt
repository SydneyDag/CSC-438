package com.example.postcard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.postcard.ui.theme.PostcardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PostcardTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    BusinessCardImage(
                        name = "Sydney D'Agostino",
                        tel = "(917) 500-0069",
                        email = "sydneydag21@gmail.com",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun BusinessCardText(name: String, tel: String, email: String, modifier: Modifier) {
    Text(
        text = name,
        fontSize = 36.sp,
        lineHeight = 50.sp,
        color = Color.White,
        textAlign = TextAlign.Center,
        fontWeight = FontWeight(700)
    )

    Text(
        text = email,
        fontSize = 22.sp,
        color = Color.White,
        textAlign = TextAlign.Center,
        lineHeight = 35.sp
    )

    Text(
        text = tel,
        fontSize = 22.sp,
        color = Color.White,
        textAlign = TextAlign.Center,
        lineHeight = 35.sp
    )
}

@Composable
fun BusinessCardImage(name: String, tel: String, email:String, modifier: Modifier = Modifier){
    val image = painterResource(R.drawable.tomco_logo)
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color(0xFF596A74))
            .padding(16.dp)
            .border(2.dp, Color.White),

        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = image,
            contentDescription = null,
            modifier = Modifier.padding(bottom = 16.dp)
                .fillMaxWidth(0.75f)
        )

        BusinessCardText(
            name = name,
            tel = tel,
            email = email,
            modifier = Modifier.fillMaxSize().padding(8.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PostcardTheme {
        BusinessCardImage("Sydney D'Agostino", tel = "(917) 500 - 0069", email="sydneydag21@gmail.com", modifier = Modifier)
    }
}