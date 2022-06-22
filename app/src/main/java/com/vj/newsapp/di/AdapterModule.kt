package com.vj.newsapp.di

import com.vj.newsapp.presentation.bookmark.adapter.BookmarkAdapter
import com.vj.newsapp.presentation.home.adapter.NewsHomeAdapter
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Created by Vijay on 17/06/2022.
 * https://github.com/thenameisvijay
 */

@Module
@InstallIn(SingletonComponent::class)
class AdapterModule {

    @Singleton
    @Provides
    fun provideHomeAdapter() = NewsHomeAdapter()

    @Singleton
    @Provides
    fun provideBookmarkAdapter() = BookmarkAdapter()

}