package com.example.slideshow.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Slide(
    @DrawableRes val image: Int,
    @StringRes val caption: Int
)