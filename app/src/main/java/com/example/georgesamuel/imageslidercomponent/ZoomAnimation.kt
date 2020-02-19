package com.example.georgesamuel.imageslidercomponent

import android.view.View
import androidx.viewpager.widget.ViewPager
import kotlin.math.abs
import kotlin.math.max

class ZoomAnimation: ViewPager.PageTransformer {

    private val MIN_SCALE = 0.70f
    private val MIN_ALPHA = 0.5f

    override fun transformPage(page: View, position: Float) {

        val pageWidth = page.width
        val pageHeight = page.height
        when {
            position < -1 -> page.alpha = 0f
            position <= 1 -> {
                val scaleFactor = max(MIN_SCALE, 1 - abs(position))
                val vertMargin = pageHeight * (1 - scaleFactor) / 2
                val horzMargin = pageWidth * (1 - scaleFactor) / 2
                when {
                    position < 0 -> page.translationX = horzMargin - vertMargin / 50
                    else -> page.translationX = -horzMargin + vertMargin / 50
                }
                page.scaleX = scaleFactor
                page.scaleY = scaleFactor
                page.alpha = (MIN_ALPHA + (scaleFactor - MIN_SCALE) / (1 - MIN_SCALE) * (1 - MIN_ALPHA))
            }
            else -> page.alpha = 0f
        }
    }
}