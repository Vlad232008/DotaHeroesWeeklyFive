package com.example.dotaheroes

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.dotaheroes.json.DotaItem
import com.squareup.moshi.Moshi
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.*
import java.io.IOException


class MainActivity : AppCompatActivity() {
    private val URL = "https://api.opendota.com/api/heroes"
    private val okHttpClient = OkHttpClient()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button.setOnClickListener {
            loadRandomFact()
        }
    }

    private fun loadRandomFact() {
        val request = Request.Builder()
            .url(URL)
            .build()
        okHttpClient.newCall(request).enqueue(object : Callback {
            override fun onResponse(call: Call, response: Response) {
                val json: String = response.body.string()
                val moshi = Moshi.Builder().build()
                val jsonAdapter = moshi.adapter(DotaItem::class.java)
                val heroes = jsonAdapter.fromJson(json).toString()
            }
            override fun onFailure(call: Call, e: IOException) {
            }
        })
    }
}