package com.dongun.kmpbookpedia

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import com.dongun.kmpbookpedia.book.data.network.KtorRemoteBookDataSource
import com.dongun.kmpbookpedia.book.data.repository.DefaultBookRepository
import com.dongun.kmpbookpedia.book.presentation.book_list.BookListScreenRoot
import com.dongun.kmpbookpedia.book.presentation.book_list.BookListViewModel
import com.dongun.kmpbookpedia.core.data.HttpClientFactory
import io.ktor.client.engine.HttpClientEngine
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App(engin: HttpClientEngine) {
    BookListScreenRoot(
        viewModel = remember {
            BookListViewModel(
                bookRepository = DefaultBookRepository(
                    remoteBookDataSource = KtorRemoteBookDataSource(
                        httpClient = HttpClientFactory.create(engine = engin)
                    )
                )
            )
        },
        onBookClick = {

        }
    )
}