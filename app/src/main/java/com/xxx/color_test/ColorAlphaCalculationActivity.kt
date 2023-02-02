package com.xxx.color_test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class ColorAlphaCalculationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_color_alpha_calculation)
        supportActionBar?.title = "RGB 颜色不透明度 Alpha 动态计算"

    }
}
