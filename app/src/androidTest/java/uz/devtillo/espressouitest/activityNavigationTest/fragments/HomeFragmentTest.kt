package uz.devtillo.espressouitest.activityNavigationTest.fragments

import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.pressBack
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.longClick
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import uz.devtillo.espressouitest.R
import uz.devtillo.espressouitest.activityNavigationTest.Test_Main

@RunWith(AndroidJUnit4::class)
class HomeFragmentTest {

    @get:Rule
    val activityRule = ActivityScenarioRule(Test_Main::class.java)

    @Test
    fun testScreen() {
        val scenario = ActivityScenario.launch(Test_Main::class.java)
        onView(withId(R.id.home_UI))
            .check(matches(isDisplayed()))
    }

    @Test
    fun isVisible() {
        //isVisible
        onView(withId(R.id.firstBtn)).check(matches(isDisplayed()))
        onView(withId(R.id.secondBtn)).check(matches(isDisplayed()))
        onView(withId(R.id.threeBtn)).check(matches(isDisplayed()))
    }

    @Test
    fun navigateFragment() {
        //navigation
        //firstFragment test
        onView(withId(R.id.firstBtn)).perform(longClick())
        onView(withId(R.id.firstUI))
            .check(matches(isDisplayed()))
        pressBack()
        onView(withId(R.id.home_UI))
            .check(matches(isDisplayed()))

        //secondFragment test
        onView(withId(R.id.secondBtn)).perform(longClick())
        onView(withId(R.id.secondUI))
            .check(matches(isDisplayed()))
        pressBack()
        onView(withId(R.id.home_UI))
            .check(matches(isDisplayed()))

        //threeFragment test
        onView(withId(R.id.threeBtn)).perform(longClick())
        onView(withId(R.id.threeUI))
            .check(matches(isDisplayed()))
        pressBack()
        onView(withId(R.id.home_UI))
            .check(matches(isDisplayed()))
    }

    @Test
    fun btnClickable() {
        //you can use there are click() its time I used longClick()
        onView(withId(R.id.firstBtn)).perform(click())
        onView(withId(R.id.secondBtn)).perform(click())
        onView(withId(R.id.threeBtn)).perform(click())
    }
}