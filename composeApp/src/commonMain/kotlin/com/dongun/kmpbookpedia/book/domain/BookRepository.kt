package com.dongun.kmpbookpedia.book.domain

import com.dongun.kmpbookpedia.core.domain.DataError
import com.dongun.kmpbookpedia.core.domain.Result

interface BookRepository {
    suspend fun searchBooks(query: String): Result<List<Book>, DataError.Remote>
    suspend fun getBookDescription(bookId: String): Result<String?, DataError>
}