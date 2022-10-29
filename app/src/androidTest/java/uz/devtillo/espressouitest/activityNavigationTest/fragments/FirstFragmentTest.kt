package uz.devtillo.espressouitest.activityNavigationTest.fragments

import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.lifecycle.Lifecycle
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.pressBack
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.longClick
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Assert
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import uz.devtillo.espressouitest.R
import uz.devtillo.espressouitest.activityNavigationTest.Test_Main
import uz.devtillo.espressouitest.activityNavigationTest.adapter.MovieAdapter

@RunWith(AndroidJUnit4::class)
class FirstFragmentTest {

    @get:Rule
    val activityRule = ActivityScenarioRule(Test_Main::class.java)

    @Test
    fun uiIsVisible() {
        val scenario = launchFragmentInContainer<FirstFragment>()

        onView(withId(R.id.rv)).check(matches(isDisplayed()))
        onView(withId(R.id.firstUI)).check(matches(isDisplayed()))
    }

    @Test
    fun itemClick() {
        val scenario = launchFragmentInContainer<FirstFragment>()

        onView(withId(R.id.rv)).perform(actionOnItemAtPosition<MovieAdapter.VhMovie>(4, click()))
    }

    @Test
    fun test_backNavigation_toMovieListFragment() {
        onView(withId(R.id.rv))
            .perform(actionOnItemAtPosition<MovieAdapter.VhMovie>(4, longClick()))

        pressBack()

        assertEquals(Lifecycle.State.DESTROYED, activityRule.scenario.state)
        onView(withId(R.id.firstUI)).check(matches(isDisplayed()))
        onView(withId(R.id.rv)).check(matches(isDisplayed()))
    }
}