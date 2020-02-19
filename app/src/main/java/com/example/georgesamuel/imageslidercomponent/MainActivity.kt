package com.example.georgesamuel.imageslidercomponent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var i = 0
    val handler = Handler()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewPagerAdapter = ViewPagerAdapter(this)
        viewPager.setPageTransformer(true, ZoomAnimation())
        viewPager.adapter = viewPagerAdapter
        viewPager.offscreenPageLimit = viewPagerAdapter.count
        viewPager.clipChildren = false

        handler.postDelayed(runnable(), 100)
    }

    private fun runnable(): Runnable {
        return Runnable {
            viewPager.currentItem = i
            Toast.makeText(this@MainActivity, "$i", Toast.LENGTH_SHORT).show()
            when (i) {
                2 -> i = 0
                else -> i++
            }
            handler.postDelayed(runnable(), 5000)
        }
    }

}
