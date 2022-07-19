package com.kursatdrhistoryapp.ebookapp.model

import androidx.annotation.DrawableRes

class BookModel(
    val id : Int,
    val category : String,
    val title : String,
    val author : String,
    val description : String,
    @DrawableRes val image : Int
) {
}