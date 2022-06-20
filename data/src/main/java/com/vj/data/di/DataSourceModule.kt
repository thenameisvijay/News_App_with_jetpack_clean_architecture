package com.vj.data.di

import com.vj.data.datasource.NewsLocalDataSource
import com.vj.data.datasource.NewsRemoteDataSource
import com.vj.data.datasourceimpl.NewsLocalDataSourceImpl
import com.vj.data.datasourceimpl.NewsRemoteDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Created by Vijay on 19/06/2022.
 * https://github.com/thenameisvijay
 */
@Module
@InstallIn(SingletonComponent::class)
abstract class DataSourceModule {

    @Binds
    @Singleton
    abstract fun bindLocalDataSource(newsLocalDataSourceImpl: NewsLocalDataSourceImpl): NewsLocalDataSource

    @Binds
    @Singleton
    abstract fun bindRemoteDataSource(newsRemoteDataSourceImpl: NewsRemoteDataSourceImpl): NewsRemoteDataSource
}