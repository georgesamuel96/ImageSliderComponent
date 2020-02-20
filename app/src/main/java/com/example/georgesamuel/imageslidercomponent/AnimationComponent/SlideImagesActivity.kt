package com.example.georgesamuel.imageslidercomponent.AnimationComponent

import android.animation.AnimatorInflater
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AnimationUtils
import com.example.georgesamuel.imageslidercomponent.R
import kotlinx.android.synthetic.main.activity_slide_images.*

class SlideImagesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_slide_images)

        val set = AnimationUtils.loadAnimation(this, R.anim.anim)
        image.startAnimation(set)

    }
}
