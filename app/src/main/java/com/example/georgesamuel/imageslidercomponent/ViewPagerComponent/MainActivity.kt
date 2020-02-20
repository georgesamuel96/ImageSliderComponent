package com.example.georgesamuel.imageslidercomponent.ViewPagerComponent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Toast
import com.example.georgesamuel.imageslidercomponent.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var i = 0
    val handler = Handler()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewPagerAdapter =
            ViewPagerAdapter(this)
        viewPager.setPageTransformer(true,
            ZoomAnimation()
        )
        viewPager.adapter = viewPagerAdapter
        viewPager.offscreenPageLimit = viewPagerAdapter.count
        viewPager.clipChildren = false

        handler.postDelayed(runnable(), 100)
    }

    private fun runnable(): Runnable {
        return Runnable {
            viewPager.currentItem = i
            when (i) {
                2 -> i = 0
                else -> i++
            }
            handler.postDelayed(runnable(), 5000)
        }
    }

}
