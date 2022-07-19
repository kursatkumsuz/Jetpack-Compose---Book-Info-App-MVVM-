package com.kursatdrhistoryapp.ebookapp.repo

import androidx.lifecycle.MutableLiveData
import com.kursatdrhistoryapp.ebookapp.R
import com.kursatdrhistoryapp.ebookapp.model.BookModel

class BookRepo {
    private var trendsList = MutableLiveData<List<BookModel>>()

    init {
        trendsList = MutableLiveData()
    }


    fun bookList() {
        val list = mutableListOf<BookModel>()

        val bookOne = BookModel(
            1,
            "Novel",
            "1984",
            "George Orwell",
            "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum",
             R.drawable.pic_book
        )
        val bookTwo = BookModel(
            2,
            "History",
            "Germen History",
            "Eric Dorn Brose",
            "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum",
            R.drawable.pic_booktwo
        )

        val bookThree = BookModel(
            3,
            "Novel",
            "Angels and Demons",
            "Dan Brown",
            "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum",
            R.drawable.pic_bookthree
        )

        val bookFour = BookModel(
            4,
            "History",
            "The Ottoman Empire",
            "Halil Inalcık",
            "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum",
            R.drawable.pic_bookfour
        )

        val bookFive = BookModel(
            5,
            "Self-Help",
            "Rich Dad Poor Dad",
            "Robert T. Kiyosaki",
            "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum",
            R.drawable.pic_bookfive
        )
        list.add(bookOne)
        list.add(bookTwo)
        list.add(bookThree)
        list.add(bookFour)
        list.add(bookFive)
        trendsList.value = list
    }

    fun getBook() : MutableLiveData<List<BookModel>> {
        return trendsList
    }

}