package com.dongun.kmpbookpedia

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.dongun.kmpbookpedia.book.presentation.book_list.BookListScreen
import com.dongun.kmpbookpedia.book.presentation.book_list.BookListState
import com.dongun.kmpbookpedia.book.presentation.book_list.books
import com.dongun.kmpbookpedia.book.presentation.book_list.components.BookSearchBar

@Preview
@Composable
private fun BookSearchBarPreview() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
    ) {
        BookSearchBar(
            modifier = Modifier.fillMaxWidth(),
            searchQuery = "",
            onSearchQueryChange = {},
            onImeSearch = {},
        )
    }
}

@Preview
@Composable
private fun BookListScreenPreview() {
    BookListScreen(
        state = BookListState(
            searchResults = books,
        ),
        onAction = {},
    )
}
