package com.dongun.kmpbookpedia.book.presentation.book_detail

import com.dongun.kmpbookpedia.book.domain.Book

sealed interface BookDetailAction {
    data object OnBackClick : BookDetailAction
    data object OnFavoriteClick : BookDetailAction
    data class OnSelectedBookChange(val book: Book) : BookDetailAction
}