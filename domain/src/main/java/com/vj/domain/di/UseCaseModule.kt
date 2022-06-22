package com.vj.domain.di

import com.vj.domain.usecase.*
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Created by Vijay on 18/06/2022.
 * https://github.com/thenameisvijay
 */
@Module
@InstallIn(SingletonComponent::class)
abstract class UseCaseModule {

    @Binds
    @Singleton
    internal abstract fun bindNewsHeadLineUseCase(sewsHeadlinesUseCaseImpl: NewsHeadlinesUseCaseImpl): NewsHeadlinesUseCase

    @Binds
    @Singleton
    internal abstract fun bindSearchNewsUseCase(searchNewsUseCaseImpl: SearchNewsUseCaseImpl): SearchNewsUseCase

    @Binds
    @Singleton
    internal abstract fun bindSaveNewsUseCase(saveNewsUseCaseImpl: SaveNewsUseCaseImpl): SaveNewsUseCase

    @Binds
    @Singleton
    internal abstract fun bindSavedNewsUseCase(savedNewsUseCaseImpl: SavedNewsUseCaseImpl): SavedNewsUseCase

    @Binds
    @Singleton
    internal abstract fun bindDeleteNewsUseCase(seleteNewsUseCaseImpl: DeleteNewsUseCaseImpl): DeleteNewsUseCase
}