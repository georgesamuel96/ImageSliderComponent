package com.example.georgesamuel.imageslidercomponent.ViewPagerComponent

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter
import com.bumptech.glide.Glide
import com.example.georgesamuel.imageslidercomponent.R
import kotlinx.android.synthetic.main.custom_layout.view.*

class ViewPagerAdapter(context: Context): PagerAdapter() {

    private val context = context
    private lateinit var layoutInflater: LayoutInflater
        val images = listOf("https://image.shutterstock.com/image-photo/african-elephant-loxodonta-africana-on-260nw-149581205.jpg",
            "https://static.turbosquid.com/Preview/001155/628/K3/elephant-rigged-3D_Z.jpg",
        "https://c402277.ssl.cf1.rackcdn.com/photos/18366/images/carousel_small/Asian_Elephants_WW252891.jpg")

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

    override fun getCount(): Int {
        return images.size
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        val view = `object` as View
        container.removeView(view)
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        layoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view = layoutInflater.inflate(R.layout.custom_layout, null)
        val imageView = view.imageView
        Glide.with(context).load(images[position]).into(imageView)
        val vp = container
        vp.addView(view, 0)
        return view
    }

}