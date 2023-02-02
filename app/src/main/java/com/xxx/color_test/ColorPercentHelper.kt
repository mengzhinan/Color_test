package com.xxx.color_test

import java.util.*

/**
 * @Author: duke
 * @DateTime: 2023-02-02 14:13:46
 * @Description: 功能描述：颜色百分比 十六进制 转换
 *
 */
object ColorPercentHelper {

    /**
     * 如：
     * 0 -> 00
     * 100 -> FF
     * @param percent 百分比。取值范围 0 ~ 100
     */
    fun getPercentToHEXString(percent: Int): String {
        var p = percent
        if (p < 0) {
            p = 0
        }
        if (p > 100) {
            p = 100
        }
        val resultInt = (1.0F * 255 / 100 * p).toInt()
        var resultString = Integer.toHexString(resultInt)
        if (resultString.length == 1) {
            resultString = "0$resultString"
        }
        resultString = resultString.uppercase(Locale.ROOT)
        return resultString
    }

}
