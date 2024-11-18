package com.dongun.kmpbookpedia.book.data.network

import com.dongun.kmpbookpedia.book.data.dto.SearchResponseDto
import com.dongun.kmpbookpedia.core.domain.DataError
import com.dongun.kmpbookpedia.core.domain.Result

interface RemoteBookDataSource {
    suspend fun searchBooks(
        query: String,
        resultLimit: Int? = null,
    ): Result<SearchResponseDto, DataError.Remote>
}