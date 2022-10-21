package uz.devtillo.espressouitest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val findViewById = findViewById<Button>(R.id.btn)

        findViewById.setOnLongClickListener {
            startActivity(Intent(this, SecondActivity::class.java))
            true
        }
    }
}