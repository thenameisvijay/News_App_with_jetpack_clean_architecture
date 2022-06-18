package com.vj.domain.di

import com.vj.domain.repository.NewsRepository
import com.vj.domain.usecase.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Created by Vijay on 18/06/2022.
 * https://github.com/thenameisvijay
 */
@Module
@InstallIn(SingletonComponent::class)
class UseCaseModule {

    @Singleton
    @Provides
    fun provideNewsHeadLineUseCase(newsRepository: NewsRepository): NewsHeadlinesUseCase =
        NewsHeadlinesUseCase(newsRepository)

    @Singleton
    @Provides
    fun provideSearchNewsUseCase(newsRepository: NewsRepository): SearchNewsUseCase =
        SearchNewsUseCase(newsRepository)

    @Singleton
    @Provides
    fun provideSaveNewsUseCase(newsRepository: NewsRepository): SaveNewsUseCase =
        SaveNewsUseCase(newsRepository)

    @Singleton
    @Provides
    fun provideSavedNewsUseCase(newsRepository: NewsRepository): SavedNewsUseCase =
        SavedNewsUseCase(newsRepository)

    @Singleton
    @Provides
    fun provideDeleteNewsUseCase(newsRepository: NewsRepository): DeleteNewsUseCase =
        DeleteNewsUseCase(newsRepository)
}