package uz.devtillo.espressouitest.activityNavigationTest

import org.junit.runner.RunWith
import org.junit.runners.Suite
import uz.devtillo.espressouitest.activityNavigationTest.fragments.FirstFragmentTest
import uz.devtillo.espressouitest.activityNavigationTest.fragments.HomeFragmentTest
import uz.devtillo.espressouitest.activityNavigationTest.fragments.SecondFragmentTest

@RunWith(Suite::class)
@Suite.SuiteClasses(
    HomeFragmentTest::class,
    FirstFragmentTest::class,
    SecondFragmentTest::class
)
class MovieFragmentTestSuite