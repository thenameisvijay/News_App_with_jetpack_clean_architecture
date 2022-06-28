package com.vj.newsapp.presentation.home

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.vj.newsapp.MainActivity
import com.vj.newsapp.R
import com.vj.newsapp.presentation.home.viewmodel.HomeViewModel
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


/**
 * Created by Vijay on 27/06/2022.
 * https://github.com/thenameisvijay
 */

@RunWith(AndroidJUnit4ClassRunner::class)
internal class HomeFragmentTest{

    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun test_isHomeFragmentVisible_onLaunch(){
        /*onView(withId(R.id.contentLoadingProgressBar))
            .check(matches(isDisplayed()))*/

        onView(withId(R.id.newsList))
            .check(matches(isDisplayed()))
    }

    @Test
    fun test_isDetailFragmentVisible(){
//        onView(withId(R.id.newsList)).perform(actionOnItemAtPosition<HomeViewModel>)
    }
}