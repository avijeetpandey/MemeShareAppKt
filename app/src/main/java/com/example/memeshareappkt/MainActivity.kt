package com.example.memeshareappkt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun shareMeme(view: View) {
        print("Share")
    }

    fun nextMeme(view: View) {
        print("Meme")
    }
}