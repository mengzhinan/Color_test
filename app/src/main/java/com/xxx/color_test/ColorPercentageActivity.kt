package com.xxx.color_test

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ColorPercentageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_color_percentage)
        supportActionBar?.title = "RGB 颜色百分比 to 十六进制 转换"

        findViewById<TextView>(R.id.tv_content).text = get0To100()
    }

    /**
     * 生成字符串：
     * 00% --> 00
     * 01% --> 02
     * ...
     * 100% --> FF
     */
    private fun get0To100(): String {
        val sb = StringBuffer("\n")
        for (i in 0..100) {
            var ii = "$i"
            if (i < 10) {
                ii = "0$i"
            }
            sb.append("$ii %    -->    ")
            sb.append(ColorPercentHelper.getPercentToHEXString(i))
            sb.append("\n")
        }
        return sb.toString()
    }
}
