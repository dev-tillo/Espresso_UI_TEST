package uz.devtillo.espressouitest

import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.activityScenarioRule
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4ClassRunner::class)
class SecondActivityTest {

    @get:Rule
    var scenario = activityScenarioRule<SecondActivity>()

    @Test
    fun checkingActivity() {
        onView(withId(R.id.espresso_second)).check(matches(isDisplayed()))
    }

    @Test
    fun checkBtnTextVisibility() {
        onView(withId(R.id.tv_second)).check(matches(isDisplayed()))
        onView(withId(R.id.btn_second)).check(matches(isDisplayed()))
    }

    @Test
    fun checkVisibilityTV() {
        onView(withId(R.id.tv_second)).check(matches(withText(R.string.app_name)))
    }
}