package com.dongun.kmpbookpedia.di

import com.dongun.kmpbookpedia.book.data.network.KtorRemoteBookDataSource
import com.dongun.kmpbookpedia.book.data.network.RemoteBookDataSource
import com.dongun.kmpbookpedia.book.data.repository.DefaultBookRepository
import com.dongun.kmpbookpedia.book.domain.BookRepository
import com.dongun.kmpbookpedia.book.presentation.book_list.BookListViewModel
import com.dongun.kmpbookpedia.core.data.HttpClientFactory
import org.koin.core.module.Module
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.bind
import org.koin.dsl.module

expect val platformModule: Module

val sharedModule = module {
    single { HttpClientFactory.create(engine = get()) }
    singleOf(::KtorRemoteBookDataSource).bind<RemoteBookDataSource>()
    singleOf(::DefaultBookRepository).bind<BookRepository>()

    viewModelOf(::BookListViewModel)
}
