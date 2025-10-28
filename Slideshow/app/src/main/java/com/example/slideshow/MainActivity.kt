package com.example.slideshow

import androidx.compose.foundation.Image
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.slideshow.ui.theme.SlideshowTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SlideshowTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Slideshow(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Slideshow(modifier: Modifier = Modifier) {
    var slideNum by remember {mutableStateOf(1)}
    var slideText by remember { mutableStateOf("1") }

    val image = when(slideNum){
        1 -> R.drawable.img1
        2 -> R.drawable.img2
        3 -> R.drawable.img3
        4 -> R.drawable.img4
        5 -> R.drawable.img5
        6 -> R.drawable.img6
        7 -> R.drawable.img7
        else -> R.drawable.max
    }

    val caption = when(slideNum){
        1 -> R.string.img1
        2 -> R.string.img2
        3 -> R.string.img3
        4 -> R.string.img4
        5 -> R.string.img5
        6 -> R.string.img6
        7 -> R.string.img7
        else -> R.string.img8
    }

    Column(
        modifier = Modifier.padding(25.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(12.dp),
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        Image(
            painter = painterResource(id = image),
            contentDescription = stringResource(caption),
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.75f)
        )

        Text(
            text = stringResource(caption),
            modifier = modifier
        )

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.wrapContentWidth()
        ) {
            Button(
                onClick = {
                    if (slideNum == 1)
                        slideNum = 8
                    else slideNum -= 1
                    slideText = slideNum.toString()

                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF3E5230),
                    contentColor = Color.White
                )
            ) {
                Text("Back")
            }

            TextField(
                value = slideText,
                onValueChange = { s ->
                    slideText = s
                    if (s.isNotEmpty()) {
                        slideNum = s.toInt()
                    }
                },
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                textStyle = LocalTextStyle.current.copy(textAlign = TextAlign.Center),
                modifier = Modifier.width(96.dp)
                    .height(55.dp)
            )

            Button(
                onClick = {
                    if (slideNum == 8)
                        slideNum = 1
                    else slideNum += 1
                    slideText = slideNum.toString()
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF3E5230),
                    contentColor = Color.White
                )
            ) {
                Text("Next")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SlideshowPreview() {
    SlideshowTheme {
        Slideshow(Modifier)
    }
}