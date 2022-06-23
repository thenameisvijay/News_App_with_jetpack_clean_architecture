package com.vj.newsapp.presentation.home.viewmodel

import androidx.lifecycle.*
import com.vj.domain.model.Articles
import com.vj.domain.model.NewsResponse
import com.vj.domain.usecase.*
import com.vj.domain.utils.ApiRequestStatus
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
//    private val app: Application,
    private val newsHeadlinesUseCase: NewsHeadlinesUseCase,
    private val saveNewsUseCase: SaveNewsUseCase,
    private val savedNewsUseCase: SavedNewsUseCase,
    private val searchNewsUseCase: SearchNewsUseCase,
    private val deleteNewsUseCase: DeleteNewsUseCase
) : ViewModel() {


    private val _response = MutableLiveData<ApiRequestStatus<NewsResponse>>()
    val newsHeadLinesResponse: LiveData<ApiRequestStatus<NewsResponse>> = _response

    val searchNewsHeadLines: MutableLiveData<ApiRequestStatus<NewsResponse>> = MutableLiveData()

    fun getNewsHeadLines(country: String, page: Int) = viewModelScope.launch(Dispatchers.IO) {
        _response.postValue(ApiRequestStatus.Loading)
        try {
            val responseResult = newsHeadlinesUseCase.execute(country, page)
            _response.postValue(responseResult)
        } catch (e: Exception) {
            _response.postValue(ApiRequestStatus.Failed(e.message.toString(), e))
        }
    }

    fun saveNews(articles: Articles) = viewModelScope.launch {
        saveNewsUseCase.execute(articles)
    }

    fun savedNews() = liveData(Dispatchers.IO) {
        savedNewsUseCase.execute().collectLatest {
            emit(it)
        }
    }

    fun searchNews(country: String, searchQuery: String, page: Int) = viewModelScope.launch {
        try {
            val responseResult = searchNewsUseCase.execute(country, searchQuery, page)
            searchNewsHeadLines.postValue(responseResult)
        } catch (e: Exception) {
            searchNewsHeadLines.postValue(ApiRequestStatus.Failed(e.message.toString(), e))
        }
    }

    fun deleteNews(articles: Articles) = viewModelScope.launch {
        deleteNewsUseCase.execute(articles)
    }
}