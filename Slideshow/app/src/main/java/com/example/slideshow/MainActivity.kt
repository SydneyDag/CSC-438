package com.example.slideshow

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.slideshow.data.Datasource
import com.example.slideshow.model.Slide
import com.example.slideshow.ui.theme.SlideshowTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SlideshowTheme {
                Surface(Modifier.fillMaxSize()) {
                    SlideList(slides = Datasource.loadSlides())
                }
            }
        }
    }
}

@Composable
fun SlideList(slides: List<Slide>, modifier: Modifier = Modifier) {
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(slides) {
            slide -> SlideCard(slide)
        }
    }
}

@Composable
fun SlideCard(slide: Slide, modifier: Modifier = Modifier) {
    Card(modifier = modifier) {
        Column {
            Image(
                painter = painterResource(slide.image),
                contentDescription = stringResource(slide.caption),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(350.dp),
                contentScale = ContentScale.Crop
            )

            Text(
                text = stringResource(slide.caption),
                modifier = Modifier.padding (12.dp),
                fontSize = 20.sp,
                lineHeight = 24.sp,
                letterSpacing = 0.15.sp,
                color = Color.Black
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SlideCardPreview() {
    SlideshowTheme {
        SlideCard(Slide(R.drawable.img1, R.string.img1))
    }
}

@Preview(showBackground = true)
@Composable
fun SlideListPreview() {
    SlideshowTheme {
        SlideList(slides = listOf(
            Slide(R.drawable.img1, R.string.img1),
            Slide(R.drawable.img2, R.string.img2)
        ))
    }
}
