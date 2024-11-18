package com.dongun.kmpbookpedia.book.presentation.book_list

import com.dongun.kmpbookpedia.book.domain.Book
import com.dongun.kmpbookpedia.core.presentation.UiText

data class BookListState(
    val searchQuery: String = "kotlin",
    val searchResults: List<Book> = emptyList(),
    val favoriteBooks: List<Book> = emptyList(),
    val isLoading: Boolean = false,
    val selectedTabIndex: Int = 0,
    val errorMessage: UiText? = null,
)
