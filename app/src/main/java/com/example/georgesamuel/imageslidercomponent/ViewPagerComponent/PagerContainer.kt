package com.example.georgesamuel.imageslidercomponent.ViewPagerComponent

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.FrameLayout
import androidx.viewpager.widget.ViewPager

class PagerContainer : FrameLayout, ViewPager.OnPageChangeListener {
    var viewPager: ViewPager? = null
        private set
    private var mNeedsRedraw = false

    constructor(context: Context) : super(context) {
        init()
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init()
    }

    constructor(context: Context, attrs: AttributeSet, defStyle: Int) : super(
        context,
        attrs,
        defStyle
    ) {
        init()
    }

    private fun init() {
        //Disable clipping of children so non-selected pages are visible
        clipChildren = false

        //Child clipping doesn't work with hardware acceleration in Android 3.x/4.x
        //You need to set this value here if using hardware acceleration in an
        // application targeted at these releases.
        setLayerType(View.LAYER_TYPE_SOFTWARE, null)
    }

    override fun onFinishInflate() {
        super.onFinishInflate()
        try {
            viewPager = getChildAt(0) as ViewPager
            viewPager!!.setOnPageChangeListener(this)
        } catch (e: Exception) {
            throw IllegalStateException("The root child of PagerContainer must be a ViewPager")
        }

    }

    override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
        //Force the container to redraw on scrolling.
        //Without this the outer pages render initially and then stay static
        if (mNeedsRedraw) invalidate()
    }

    override fun onPageSelected(position: Int) {}

    override fun onPageScrollStateChanged(state: Int) {
        mNeedsRedraw = state != ViewPager.SCROLL_STATE_IDLE
    }
}
