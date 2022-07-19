package com.kursatdrhistoryapp.ebookapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.kursatdrhistoryapp.ebookapp.model.BookModel
import com.kursatdrhistoryapp.ebookapp.repo.BookRepo

class MainScreenViewModel : ViewModel() {
    var bookList = MutableLiveData<List<BookModel>>()
    val bookRepo = BookRepo()

    init {
        loadBooks()
        bookList = bookRepo.getBook()
    }

    fun loadBooks() {
        bookRepo.bookList()
    }
}