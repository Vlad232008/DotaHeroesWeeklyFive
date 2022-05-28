package com.example.dotaheroes

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.dotaheroes.databinding.HeroListBinding
import com.example.dotaheroes.json.HeroInfo

class HeroAdapter(val listener: Listener, private val names: List<HeroInfo>) :
    RecyclerView.Adapter<HeroAdapter.MyViewHolder>() {
    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name: TextView = itemView.findViewById(R.id.tvName)
        val icon: ImageView = itemView.findViewById(R.id.ivIcon)
        val button: Button = itemView.findViewById(R.id.btnHero)
        companion object {
            fun create(parent: ViewGroup): MyViewHolder {
                return MyViewHolder(
                    LayoutInflater.from(parent.context)
                        .inflate(R.layout.hero_list, parent, false)
                )
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val base_URl = "https://api.opendota.com${names[position].icon}"
        holder.name.text = names[position].localized_name
        holder.icon.load(base_URl)
        holder.button.setOnClickListener {
            listener.onClickItem(names[position])
        }
    }

    override fun getItemCount(): Int {
        return names.size
    }
    interface Listener{
        fun onClickItem(heroInfo: HeroInfo)
    }
}