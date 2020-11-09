package com.example.imagination

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_imaginaion_video_player.*

class ImaginaionVideoPlayer : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_imaginaion_video_player)

        val image = intent.getStringExtra(MainActivity.IMAGE_URI)
        Picasso
            .get()
            .load(image)
            .into(screen_image)

    }
}