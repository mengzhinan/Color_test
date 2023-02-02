package com.xxx.color_test

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ColorAlphaCalculationActivity : AppCompatActivity() {

    private var etColorStr: EditText? = null
    private var etAlphaPercent: EditText? = null
    private var tvColorResult: TextView? = null
    private var btnCount: Button? = null
    private var vBgShow: View? = null
    private var tvTextShow: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_color_alpha_calculation)
        supportActionBar?.title = "RGB 颜色不透明度 Alpha 动态计算"

        initView()
    }

    private fun initView() {
        etColorStr = findViewById(R.id.et_color_str)
        etAlphaPercent = findViewById(R.id.et_alpha_percent)
        tvColorResult = findViewById(R.id.tv_color_result)
        btnCount = findViewById(R.id.btn_count)
        vBgShow = findViewById(R.id.v_bg_show)
        tvTextShow = findViewById(R.id.tv_text_show)

        btnCount?.setOnClickListener {
            val colorStrInput = getColorStr()
            val percentInt = getAlphaPercent()
            val colorStrCount = ColorAlphaHelper.combineColorAlphaByPercent(
                Color.parseColor(colorStrInput), percentInt
            )
            tvColorResult?.text = colorStrCount

            val colorIntCount = Color.parseColor(colorStrCount)
            vBgShow?.setBackgroundColor(colorIntCount)
            tvTextShow?.setTextColor(colorIntCount)
        }
    }

    private fun getColorStr(): String {
        var colorStr = etColorStr?.text?.toString() ?: ""
        try {
            Color.parseColor(colorStr)
        } catch (e: Exception) {
            e.printStackTrace()
            colorStr = "#000000"
            etColorStr?.setText(colorStr)
        }
        return colorStr
    }

    private fun getAlphaPercent(): Int {
        var percentStr = etAlphaPercent?.text?.toString() ?: ""
        var percentInt = 0
        try {
            percentInt = Integer.parseInt(percentStr)
            if (percentInt < 0) {
                percentStr = "0"
                percentInt = 0
            }
            if (percentInt > 100) {
                percentStr = "100"
                percentInt = 100
            }
        } catch (e: Exception) {
            e.printStackTrace()
            percentStr = "100"
            percentInt = 100
        }
        etAlphaPercent?.setText(percentStr)
        return percentInt
    }

    override fun onResume() {
        super.onResume()
        btnCount?.performClick()
    }
}
