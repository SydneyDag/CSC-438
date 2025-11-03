package com.example.slideshow.data

import com.example.slideshow.R
import com.example.slideshow.model.Slide

object Datasource {
    fun loadSlides(): List<Slide> = listOf(
        Slide(R.drawable.img1, R.string.img1),
        Slide(R.drawable.img2, R.string.img2),
        Slide(R.drawable.img3, R.string.img3),
        Slide(R.drawable.img4, R.string.img4),
        Slide(R.drawable.img5, R.string.img5),
        Slide(R.drawable.img6, R.string.img6),
        Slide(R.drawable.img7, R.string.img7),
        Slide(R.drawable.max,  R.string.img8),
        Slide(R.drawable.img9,  R.string.img9),
        Slide(R.drawable.img10,  R.string.img10)
    )
}
