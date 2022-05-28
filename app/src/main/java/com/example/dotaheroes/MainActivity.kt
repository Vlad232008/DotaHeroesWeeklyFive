package com.example.dotaheroes

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dotaheroes.databinding.ActivityMainBinding
import com.example.dotaheroes.json.HeroInfo
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import okhttp3.*
import java.io.IOException


open class MainActivity : AppCompatActivity(), HeroAdapter.Listener {
    lateinit var binding: ActivityMainBinding
    private val URL_HEROINFO = "https://api.opendota.com/api/heroStats"
    private val okHttpClient = OkHttpClient()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getHeroInfo()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        while (heroInfo.isEmpty()) {
            continue
        }
        initRcV()
    }

    private fun getHeroInfo() {
        val request = Request.Builder()
            .url(URL_HEROINFO)
            .build()
        okHttpClient.newCall(request).enqueue(object : Callback {
            override fun onResponse(call: Call, response: Response) {
                val json: String = response.body.string()
                val moshi = Moshi.Builder().build()
                val listType = Types.newParameterizedType(List::class.java, HeroInfo::class.java)
                val adapter: JsonAdapter<List<HeroInfo>> = moshi.adapter(listType)
                heroInfo = adapter.fromJson(json)!!
            }

            override fun onFailure(call: Call, e: IOException) {
            }
        })
    }

    private fun initRcV() = with(binding) {
        rcView.layoutManager = LinearLayoutManager(this@MainActivity)
        rcView.adapter = HeroAdapter(this@MainActivity, heroInfo)
    }

    override fun onClickItem(heroInfo: List<HeroInfo>, position: Int) {
        val intentHero = Intent(this, HeroInfoActivity::class.java)
        intentHero.putExtra("id",position)
        startActivity(intentHero)
    }

    companion object{
        var heroInfo = listOf<HeroInfo>()
    }
}