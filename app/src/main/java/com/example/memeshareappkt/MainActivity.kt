package com.example.memeshareappkt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.bumptech.glide.Glide
import com.example.memeshareappkt.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        loadMeme()
    }

    private fun loadMeme() {
        // Instantiate the RequestQueue.
        val queue = Volley.newRequestQueue(this)
        val url = "https://meme-api.com/gimme"

        // Request a string response from the provided URL.
        val jsonObjectRequest = JsonObjectRequest(Request.Method.GET,url,null,
            { response ->
                val url = response.getString("url")
                Glide.with(this).load(url).into(binding.memeImageView)
            }, {
               Toast.makeText(this, "Something went wrong", Toast.LENGTH_SHORT).show()
        })

        queue.add(jsonObjectRequest)
    }

    fun shareMeme(view: View) {
        Log.d("share","Share pressed")
    }

    fun nextMeme(view: View) {
       loadMeme()
    }
}