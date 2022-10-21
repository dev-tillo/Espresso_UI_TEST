package uz.devtillo.espressouitest

import org.junit.runner.RunWith
import org.junit.runners.Suite

@RunWith(Suite::class)
@Suite.SuiteClasses(MainActivityTest::class, SecondActivityTest::class)
class ActivityTestSuit {


}