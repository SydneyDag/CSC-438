package com.example.nav

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ContactPage(modifier: Modifier = Modifier) {
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
            painter = painterResource(R.drawable.tomco_logo),
            contentDescription = "Logo",
            modifier = Modifier
                .padding(bottom = 16.dp)
                .fillMaxWidth(0.75f)
        )
        Text(
            text = "Sydney D'Agostino",
            fontSize = 32.sp,
            lineHeight = 44.sp,
            color = Color.White,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = "sydneydag21@gmail.com",
            fontSize = 20.sp,
            color = Color.White,
            textAlign = TextAlign.Center,
            lineHeight = 30.sp
        )
        Text(
            text = "(917) 500-0069",
            fontSize = 20.sp,
            color = Color.White,
            textAlign = TextAlign.Center,
            lineHeight = 30.sp
        )
    }
}
