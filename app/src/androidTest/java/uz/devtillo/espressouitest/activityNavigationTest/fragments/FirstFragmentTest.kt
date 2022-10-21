package uz.devtillo.espressouitest.activityNavigationTest.fragments

import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class FirstFragmentTest {

    @Test
    fun uiIsVisible(){
        val scenario = launchFragmentInContainer<FirstFragment>()
    }


}