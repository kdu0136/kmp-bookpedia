package com.dongun.kmpbookpedia.book.data.repository

import androidx.sqlite.SQLiteException
import com.dongun.kmpbookpedia.book.data.database.FavoriteBookDao
import com.dongun.kmpbookpedia.book.data.mappers.toBook
import com.dongun.kmpbookpedia.book.data.mappers.toBookEntity
import com.dongun.kmpbookpedia.book.data.network.RemoteBookDataSource
import com.dongun.kmpbookpedia.book.domain.Book
import com.dongun.kmpbookpedia.book.domain.BookRepository
import com.dongun.kmpbookpedia.core.domain.DataError
import com.dongun.kmpbookpedia.core.domain.EmptyResult
import com.dongun.kmpbookpedia.core.domain.Result
import com.dongun.kmpbookpedia.core.domain.map
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class DefaultBookRepository(
    private val remoteBookDataSource: RemoteBookDataSource,
    private val favoriteBookDao: FavoriteBookDao,
) : BookRepository {
    override suspend fun searchBooks(query: String): Result<List<Book>, DataError.Remote> {
        return remoteBookDataSource.searchBooks(query = query)
            .map { dto ->
                dto.results.map { it.toBook() }
            }
    }

    override suspend fun getBookDescription(bookId: String): Result<String?, DataError> {
        val localResult = favoriteBookDao.getFavoriteBook(id = bookId)

        return if (localResult == null) {
            remoteBookDataSource
                .getBookDetails(bookWorkId = bookId)
                .map { it.description }
        } else {
            Result.Success(localResult.description)
        }
    }

    override fun getFavoriteBooks(): Flow<List<Book>> {
        return favoriteBookDao
            .getFavoriteBooks()
            .map { entities ->
                entities.map { it.toBook() }
            }
    }

    override fun isBookFavorite(id: String): Flow<Boolean> {
        return favoriteBookDao
            .getFavoriteBooks()
            .map { bookEntities ->
                bookEntities.any { it.id == id }
            }

    }

    override suspend fun markAsFavorite(book: Book): EmptyResult<DataError.Local> {
        return try {
            favoriteBookDao.upsert(book.toBookEntity())
            Result.Success(Unit)
        } catch (e: SQLiteException) {
            Result.Error(DataError.Local.DISK_FULL)
        }
    }

    override suspend fun deleteFromFavorites(id: String) {
        favoriteBookDao.deleteFavoriteBook(id = id)
    }
}