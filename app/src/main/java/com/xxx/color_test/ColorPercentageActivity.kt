package com.xxx.color_test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class ColorPercentageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_color_percentage)
        supportActionBar?.title = "RGB 颜色百分比 to 十六进制 转换"

    }
}