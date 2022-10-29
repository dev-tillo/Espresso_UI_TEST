package uz.devtillo.espressouitest.activityNavigationTest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import uz.devtillo.espressouitest.R
import uz.devtillo.espressouitest.databinding.ActivityTestMainBinding

class Test_Main : AppCompatActivity() {

//    RV navigation not worked
    private lateinit var binding: ActivityTestMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTestMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}