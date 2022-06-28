package com.vj.newsapp.presentation.home.viewmodel

import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner

/**
 * Created by Vijay on 28/06/2022.
 * https://github.com/thenameisvijay
 */

@HiltAndroidTest
@RunWith(MockitoJUnitRunner::class)
class HomeViewModelTest {

    @get: Rule
    var hiltRule = HiltAndroidRule(this)

    @Before
    fun setUp() {
        hiltRule.inject()
    }

    @Test
    fun `get news list`() {

    }
}