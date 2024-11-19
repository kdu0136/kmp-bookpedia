package com.dongun.kmpbookpedia.book.data.repository

import com.dongun.kmpbookpedia.book.data.mappers.toBook
import com.dongun.kmpbookpedia.book.data.network.RemoteBookDataSource
import com.dongun.kmpbookpedia.book.domain.Book
import com.dongun.kmpbookpedia.book.domain.BookRepository
import com.dongun.kmpbookpedia.core.domain.DataError
import com.dongun.kmpbookpedia.core.domain.Result
import com.dongun.kmpbookpedia.core.domain.map

class DefaultBookRepository(
    private val remoteBookDataSource: RemoteBookDataSource,
) : BookRepository {
    override suspend fun searchBooks(query: String): Result<List<Book>, DataError.Remote> {
        return remoteBookDataSource.searchBooks(query = query)
            .map { dto ->
                dto.results.map { it.toBook() }
            }
    }

    override suspend fun getBookDescription(bookId: String): Result<String?, DataError> {
        return remoteBookDataSource.getBookDetails(bookWorkId = bookId)
            .map { dto ->
                dto.description
            }
    }
}