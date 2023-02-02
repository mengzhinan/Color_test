package com.xxx.color_test

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.title = "RGB 颜色工具"

        findViewById<Button>(R.id.btn_of_percent_convert).setOnClickListener {
            startActivity(Intent(this, ColorPercentageActivity::class.java))
        }

        findViewById<Button>(R.id.btn_of_alpha_calculate).setOnClickListener {
            startActivity(Intent(this, ColorAlphaCalculationActivity::class.java))
        }

    }
}
