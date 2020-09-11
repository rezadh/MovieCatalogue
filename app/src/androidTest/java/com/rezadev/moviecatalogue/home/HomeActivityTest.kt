@file:Suppress("DEPRECATION")

package com.rezadev.moviecatalogue.home

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.rule.ActivityTestRule
import com.rezadev.moviecatalogue.R
import com.rezadev.moviecatalogue.utils.DataDummy

import org.junit.Rule
import org.junit.Test

@Suppress("DEPRECATION")
class HomeActivityTest {
    private val movieCourse = DataDummy.generateDummyMovie()
    private val movieTvCourse = DataDummy.generateDummyMovieTv()

    @get:Rule
    var activityRule = ActivityTestRule(HomeActivity::class.java)

    @Test
    fun loadMovie() {
        onView(withId(R.id.rv_movies)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_movies)).perform(RecyclerViewActions.
        scrollToPosition<RecyclerView.ViewHolder>(movieCourse.size))
    }

    @Test
    fun loadDetailMovie(){
        onView(withId(R.id.rv_movies)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(withId(R.id.text_title)).check(matches(isDisplayed()))
        onView(withId(R.id.text_title)).check(matches(withText(movieCourse[0].title)))
    }

    @Test
    fun loadMovieTv() {
        onView(withText("Movie Tv")).perform(click())
        onView(withId(R.id.rv_movies_tv)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_movies_tv)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(movieTvCourse.size))
    }

}