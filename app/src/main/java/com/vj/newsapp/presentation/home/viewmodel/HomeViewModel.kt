package com.vj.newsapp.presentation.home.viewmodel

import android.app.Application
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.vj.domain.model.News
import com.vj.domain.model.NewsResponse
import com.vj.domain.usecase.*
import com.vj.domain.utils.ApiRequestStatus
import com.vj.newsapp.R
import com.vj.newsapp.utils.ConnectionManager
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by Vijay on 17/06/2022.
 * https://github.com/thenameisvijay
 */

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val app: Application,
    private val newsHeadlinesUseCase: NewsHeadlinesUseCase,
    private val saveNewsUseCase: SaveNewsUseCase,
    private val savedNewsUseCase: SavedNewsUseCase,
    private val searchNewsUseCase: SearchNewsUseCase,
    private val deleteNewsUseCase: DeleteNewsUseCase
) : ViewModel() {

    @Inject
    lateinit var connectivityManager: ConnectionManager


    val newsHeadLines: MutableLiveData<ApiRequestStatus<NewsResponse>> = MutableLiveData()
    val searchNewsHeadLines: MutableLiveData<ApiRequestStatus<NewsResponse>> = MutableLiveData()

    fun getNewsHeadLines(country: String, page: Int) = viewModelScope.launch(Dispatchers.IO) {
        try {
            if (connectivityManager.isNetworkAvailable.value == true) {
                val responseResult = newsHeadlinesUseCase.execute(country, page)
                newsHeadLines.postValue(responseResult)
            } else {
                newsHeadLines.postValue(ApiRequestStatus.Failed(app.getString(R.string.no_internet)))
            }
        } catch (e: Exception) {
            newsHeadLines.postValue(ApiRequestStatus.Failed(e.message.toString(), e))
        }
    }

    fun saveNews(news: News) = viewModelScope.launch {
        saveNewsUseCase.execute(news)
    }

    fun savedNews() = liveData(Dispatchers.IO) {
        savedNewsUseCase.execute().collectLatest{
            emit(it)
        }
    }

    fun searchNews(country: String, searchQuery: String, page: Int) = viewModelScope.launch {
        try {
            if (connectivityManager.isNetworkAvailable.value == true) {
                val responseResult = searchNewsUseCase.execute(country, searchQuery, page)
                searchNewsHeadLines.postValue(responseResult)
            } else {
                searchNewsHeadLines.postValue(ApiRequestStatus.Failed(app.getString(R.string.no_internet)))
            }
        } catch (e: Exception) {
            searchNewsHeadLines.postValue(ApiRequestStatus.Failed(e.message.toString(), e))
        }
    }

    fun deleteNews(news: News) = viewModelScope.launch {
        deleteNewsUseCase.execute(news)
    }
}