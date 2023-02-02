package com.xxx.color_test

import android.content.Context
import android.graphics.Color
import androidx.annotation.ColorInt
import androidx.annotation.ColorRes
import androidx.annotation.IntRange
import androidx.core.content.ContextCompat

/**
 * @Author: duke
 * @DateTime: 2023-02-02 14:13:26
 * @Description: 功能描述：
 *
 */
object ColorAlphaHelper {

    @ColorInt
    fun getColor(context: Context, @ColorRes colorResId: Int): Int {
        return ContextCompat.getColor(context, colorResId)
    }

    fun combineColorAlphaByPercent(
        context: Context, @ColorRes colorResId: Int, @IntRange(from = 0, to = 100) percent: Int
    ): String {
        return combineColorAlphaByPercent(getColor(context, colorResId), percent)
    }

    fun combineColorAlphaByPercent(
        colorString: String, @IntRange(from = 0, to = 100) percent: Int
    ): String {
        return combineColorAlphaByPercent(Color.parseColor(colorString), percent)
    }

    /**
     * 返回颜色的十六进制值。
     * 如：#FF0000
     */
    fun combineColorAlphaByPercent(
        colorInt: Int, @IntRange(from = 0, to = 100) percent: Int
    ): String {

        // 生成 alpha 十六进制值
        var aHexString = ColorPercentHelper.getPercentToHEXString(percent)
        if (aHexString.length == 1) {
            aHexString = "0$aHexString"
        }

        // 获取 red 十六进制值
        var rHexString = Integer.toHexString(Color.red(colorInt))
        if (rHexString.length == 1) {
            rHexString = "0$rHexString"
        }

        // 获取 green 十六进制值
        var gHexString = Integer.toHexString(Color.green(colorInt))
        if (gHexString.length == 1) {
            gHexString = "0$gHexString"
        }

        // 获取 blue 十六进制值
        var bHexString = Integer.toHexString(Color.blue(colorInt))
        if (bHexString.length == 1) {
            bHexString = "0$bHexString"
        }

        return "#$aHexString$rHexString$gHexString$bHexString"
    }


}
