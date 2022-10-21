package uz.devtillo.espressouitest

import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.longClick
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.activityScenarioRule
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import androidx.test.runner.AndroidJUnitRunner
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class MainActivityTest {

    @get:Rule
    var scenario = activityScenarioRule<MainActivity>()

    @Test
    fun checkActivity() {
        onView(withId(R.id.espresso_main)).check(matches(isDisplayed()))
    }

    @Test
    fun checkTextVisibility() {
        onView(withId(R.id.tv)).check(matches(isDisplayed()))
        onView(withId(R.id.btn)).check(matches(isDisplayed()))
    }

    @Test
    fun checkVisibilityBtn() {
        onView(withId(R.id.tv)).check(matches(withText(R.string.app_name)))
    }

    @Test
    fun navigateToBtnClick() {
        onView(withId(R.id.btn)).perform(click())
        onView(withId(R.id.espresso_main)).check(matches(isDisplayed()))
    }

    @Test
    fun onBacPressed() {
        onView(withId(R.id.btn)).perform(longClick())
        onView(withId(R.id.espresso_second)).check(matches(isDisplayed()))
        Espresso.pressBack()

        onView(withId(R.id.espresso_main)).check(matches(isDisplayed()))
    }
}