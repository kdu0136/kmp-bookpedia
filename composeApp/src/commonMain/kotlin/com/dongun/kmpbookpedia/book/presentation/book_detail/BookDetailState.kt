package com.dongun.kmpbookpedia.book.presentation.book_detail

import com.dongun.kmpbookpedia.book.domain.Book

data class BookDetailState(
    val isLoading: Boolean = true,
    val isFavorite: Boolean = false,
    val book: Book? = null,
)
